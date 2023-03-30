package com.mhollink.gainzgraph.experience;

import com.mhollink.gainzgraph.GainzGraphPlugin;
import com.mhollink.gainzgraph.config.GraphConfig;
import com.mhollink.gainzgraph.util.ListUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Skill;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.mhollink.gainzgraph.config.Constants.SKILLS;
import static com.mhollink.gainzgraph.util.ListUtils.getElement;

/**
 * The ExperienceDataManager saves all the exp updates created by the {@link ExperienceTracker} and allows other
 * services to retrieve information about the skills that are trained by the player.
 */
@Slf4j
@Singleton
public class ExperienceDataManager
		implements ExperienceChangeListener
{
	private final Map<Skill, List<Integer>> expTickListPerSkill = new HashMap<>();
	private final GraphConfig config;
	
	@Getter
	private final List<Skill> lastTrainedSkills = new ArrayList<>();
	
	private ExperienceObserver observer;
	
	@Inject
	public ExperienceDataManager(GainzGraphPlugin plugin, ExperienceObserver observer)
	{
		this.config = plugin.getConfig();
		this.observer = observer;
		SKILLS.forEach(skill -> expTickListPerSkill.put(skill, new ArrayList<>()));
	}
	
	public void startListeningForExpDrops()
	{
		observer.register(this);
	}
	
	public void stopListening()
	{
		observer.unregister(this);
	}
	
	@Override
	public void update(Skill skill, int expDrop)
	{
		expTickListPerSkill.get(skill).add(expDrop);
		
		if (expDrop != 0 && !lastTrainedSkills.contains(skill)) {
			lastTrainedSkills.add(skill);
			log.info("Add skill '{}' to the list of trained skills", skill);
			if (lastTrainedSkills.size() > config.maxSkillsToGraph()) {
				Skill removedSkill = lastTrainedSkills.get(0);
				log.info("Removed skill '{}' from the list of trained skills", removedSkill);
				lastTrainedSkills.remove(0);
			}
		}
	}
	
	public int getExperienceAtPointInTime(Skill skill, int tickNum)
	{
		if (skill == Skill.OVERALL) {
			return 0;
		}
		return Optional.ofNullable(getElement(expTickListPerSkill.get(skill), tickNum)).orElse(-1);
	}
	
	public int getMostRecentXp(Skill skill)
	{
		if (skill == Skill.OVERALL) {
			return 0;
		}
		return ListUtils.getLast(expTickListPerSkill.get(skill));
	}
	
	public int getMaxExpDrop()
	{
		return expTickListPerSkill.values().stream().flatMap(Collection::stream).mapToInt(v -> v).max().orElse(0);
	}
	
	public void reset()
	{
		SKILLS.forEach(skill -> expTickListPerSkill.get(skill).clear());
		lastTrainedSkills.clear();
	}
}

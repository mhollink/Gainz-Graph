package com.mhollink.gainzgraph.experience;

import com.mhollink.gainzgraph.GainzGraphPlugin;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

import static com.mhollink.gainzgraph.config.Constants.SKILLS;

/**
 * The ExperienceTracker checks for each skill if there was an experience difference between the current update
 * invocation and the previous. It then publishes the exp difference to the {@link ExperienceObserver} to notify
 * all the {@link ExperienceChangeListener}
 */
@Slf4j
@Singleton
public class ExperienceTracker
{
	
	private Client client;
	private final Map<Skill, Integer> previousSkillExperience = new HashMap<>();
	
	private boolean isInitialUpdate = true;
	
	private ExperienceObserver observer;
	
	@Inject
	public ExperienceTracker(GainzGraphPlugin plugin, ExperienceObserver observer)
	{
		this.client = plugin.getClient();
		this.observer = observer;
	}
	
	public void update()
	{
		if (isInitialUpdate) {
			SKILLS.forEach(skill -> previousSkillExperience.put(skill, client.getSkillExperience(skill)));
			isInitialUpdate = false;
		}
		
		SKILLS.forEach(this::updateExpForSkill);
	}
	
	private void updateExpForSkill(Skill skill)
	{
		int currentSkillExp = client.getSkillExperience(skill);
		int previousSkillExp = previousSkillExperience.get(skill);
		
		updateListeners(skill, currentSkillExp - previousSkillExp);
		previousSkillExperience.put(skill, currentSkillExp);
	}
	
	private void updateListeners(Skill skill, int expDrop)
	{
		observer.notify(skill, expDrop);
	}
}
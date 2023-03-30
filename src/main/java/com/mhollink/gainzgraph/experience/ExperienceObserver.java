package com.mhollink.gainzgraph.experience;

import net.runelite.api.Skill;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ExperienceObserver
{
	
	private List<ExperienceChangeListener> updateListeners = new ArrayList<>();
	
	public void register(ExperienceChangeListener listener)
	{
		updateListeners.add(listener);
	}
	
	public void unregister(ExperienceChangeListener listener)
	{
		updateListeners.remove(listener);
	}
	
	void notify(Skill skill, int expDrop)
	{
		updateListeners.forEach(listener -> listener.update(skill, expDrop));
	}
}

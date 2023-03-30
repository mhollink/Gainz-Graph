package com.mhollink.gainzgraph.experience;

import net.runelite.api.Skill;

@FunctionalInterface
public interface ExperienceChangeListener
{
	/**
	 * @param skill the skill that has an update
	 * @param expDrop the amount of exp generated since the last update
	 */
	void update(Skill skill,
				int expDrop);
}

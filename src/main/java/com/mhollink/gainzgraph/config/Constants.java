package com.mhollink.gainzgraph.config;

import net.runelite.api.Skill;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Constants
{
	public static final int MARGIN_LEFT = 48;
	public static final int MARGIN_RIGHT = 16;
	public static final int HORIZONTAL_MARGIN = MARGIN_LEFT + MARGIN_RIGHT;
	
	public static final int MARGIN_TOP = 16;
	public static final int MARGIN_BOTTOM = 16;
	public static final int VERTICAL_MARGINS = MARGIN_TOP + MARGIN_BOTTOM;
	
	public static final int MARGIN_TIME_LABEL = 8;
	
	public static final int LEGEND_WIDTH = 93;
	public static final int LEGEND_MARGIN = 16;
	
	public static final int GRAPH_LINES = 5;
	
	public static final List<Skill> SKILLS = Arrays.stream(Skill.values()).filter(skill -> skill != Skill.OVERALL)
												   .collect(Collectors.toList());
}

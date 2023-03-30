package com.mhollink.gainzgraph.config;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("gainz-graph")
public interface GraphConfig
		extends Config
{
	
	@ConfigSection(name = "Overlay config", description = "Configuration for the graph overlay", position = 0)
	String overlayConfig = "overlayConfig";
	
	@ConfigItem(section = overlayConfig, keyName = "graphWidth", name = "Graph Width", description = "Configures the width of the graph.")
	default int graphWidth()
	{
		return 200;
	}
	
	@ConfigItem(section = overlayConfig, keyName = "graphHeight", name = "Graph Height", description = "Configures the height of the graph.")
	default int graphHeight()
	{
		return 100;
	}
	
	@Range(min = 1, max = 100)
	@ConfigItem(section = overlayConfig, keyName = "graphBackgroundTransparency", name = "Background Transparency", description = "The background transparency.")
	default int graphBackgroundTransparency()
	{
		return 100;
	}
	
	@ConfigSection(name = "Graph config", description = "Configuration for the graph data", position = 1)
	String graphConfig = "graphConfig";
	
	@ConfigItem(section = graphConfig, keyName = "maxSkillsToGraph", name = "Number of skills to plot", description = "")
	default int maxSkillsToGraph()
	{
		return 8;
	}
	
	@Range(min = 0, max = 60)
	@ConfigItem(section = graphConfig, keyName = "minutesToPlot", name = "Timespan in minutes", description = "The timespan of the graph in minutes, use 0 for 'since login'")
	default int minutesToPlot()
	{
		return 10;
	}
}
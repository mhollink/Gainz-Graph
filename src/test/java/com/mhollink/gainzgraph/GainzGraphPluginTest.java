package com.mhollink.gainzgraph;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;


public class GainzGraphPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GainzGraphPlugin.class);
		RuneLite.main(args);
	}
}
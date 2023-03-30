package com.mhollink.gainzgraph;

import com.google.inject.Provides;
import com.mhollink.gainzgraph.config.GraphConfig;
import com.mhollink.gainzgraph.experience.ExperienceDataManager;
import com.mhollink.gainzgraph.experience.ExperienceTracker;
import com.mhollink.gainzgraph.overlay.GraphOverlay;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(name = "Gainz Graph")
@Getter
public class GainzGraphPlugin
		extends Plugin
{
	
	@Inject
	private Client client;
	@Inject
	private GraphConfig config;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private GraphOverlay overlay;
	@Inject
	private ExperienceTracker experienceTracker;
	@Inject
	private ExperienceDataManager experienceDataManager;
	
	private boolean isLoggedIn = false;
	
	public int tickCount = 0;
	public long startTime = 0;
	public long currentTime = 0;

//	public Graph graph;
//	public ArrayList<Skill> currentlyGraphedSkills = new ArrayList<>();
	
	@Provides
	public GraphConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GraphConfig.class);
	}
	
	@Override
	public void startUp()
	{
		experienceDataManager.startListeningForExpDrops();
		overlayManager.add(overlay);
	}
	
	@Override
	public void shutDown()
	{
		overlayManager.remove(overlay);
		experienceDataManager.stopListening();
	}
	
	@Subscribe
	public void onGameTick(GameTick tick)
	{
		currentTime = System.currentTimeMillis();
		experienceTracker.update();
		tickCount++;
	}
	
	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
			log.info("Player has logged in, start monitoring for exp drops");
			experienceDataManager.reset();
			tickCount = 0;
			startTime = System.currentTimeMillis();
			experienceDataManager.startListeningForExpDrops();
			isLoggedIn = true;
		}
		
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN && isLoggedIn) {
			log.info("Player has returned to the login screen, stop monitoring for exp drops");
			experienceDataManager.stopListening();
			isLoggedIn = false;
		}
	}
}

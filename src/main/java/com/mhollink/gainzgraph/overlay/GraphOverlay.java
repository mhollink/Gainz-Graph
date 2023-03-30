package com.mhollink.gainzgraph.overlay;

import com.google.inject.Inject;
import com.mhollink.gainzgraph.GainzGraphPlugin;
import com.mhollink.gainzgraph.experience.ExperienceDataManager;
import com.mhollink.gainzgraph.overlay.graph.ExperienceGraph;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

import java.awt.*;

@Slf4j
public class GraphOverlay
		extends OverlayPanel
{
	
	private final LayoutableRenderableEntity experienceGraph;
	
	@Inject
	private GraphOverlay(GainzGraphPlugin plugin, ExperienceDataManager experienceDataManager)
	{
		this.experienceGraph = new ExperienceGraph(plugin.getConfig(), experienceDataManager);
		
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPosition(OverlayPosition.TOP_LEFT);
	}
	
	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().add(experienceGraph);
		panelComponent.setBackgroundColor(new Color(0, 0, 0, 0));
		
		return super.render(graphics);
	}
}

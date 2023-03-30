package com.mhollink.gainzgraph.overlay.graph.components;

import com.mhollink.gainzgraph.config.GraphConfig;
import lombok.Getter;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

import java.awt.*;

public class DrawableContext
{
	@Getter
	private Graphics2D graphics;
	@Getter
	private GraphConfig config;
	@Getter
	private LayoutableRenderableEntity panel;
	
	private DrawableContext(Graphics2D graphics, GraphConfig config, LayoutableRenderableEntity panel)
	{
		this.graphics = graphics;
		this.config = config;
		this.panel = panel;
	}
	
	public static DrawableContext createDrawableContext(Graphics2D graphics,
														GraphConfig config,
														LayoutableRenderableEntity panel)
	{
		return new DrawableContext(graphics, config, panel);
	}
}

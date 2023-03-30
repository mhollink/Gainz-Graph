package com.mhollink.gainzgraph.overlay.graph.components;

import com.mhollink.gainzgraph.config.Constants;
import com.mhollink.gainzgraph.util.ColorUtils;

import java.awt.*;

public class PanelBackground
		implements DrawableComponent
{
	@Override
	public void draw(DrawableContext context)
	{
		int backgroundTransparency = ColorUtils.calculateAlphaValue(context.getConfig().graphBackgroundTransparency());
		int width = Constants.HORIZONTAL_MARGIN + context.getConfig().graphWidth();
		int height = context.getPanel().getBounds().height;
		
		context.getGraphics().setColor(new Color(216, 196, 157, backgroundTransparency));
		context.getGraphics().fillRect(0, 0, width, height);
		context.getGraphics().setColor(new Color(101, 88, 65, backgroundTransparency));
		context.getGraphics().drawRect(0, 0, width, height);
		context.getGraphics().drawRect(0, 0, width, height);
	}
}

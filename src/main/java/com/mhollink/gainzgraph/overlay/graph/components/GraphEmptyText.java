package com.mhollink.gainzgraph.overlay.graph.components;

import com.mhollink.gainzgraph.config.Constants;
import com.mhollink.gainzgraph.util.ColorUtils;

import java.awt.*;

public class GraphEmptyText
		implements DrawableComponent
{
	@Override
	public void draw(DrawableContext context)
	{
		Graphics2D graphics = context.getGraphics();
		int backgroundTransparency = ColorUtils.calculateAlphaValue(context.getConfig().graphBackgroundTransparency());
		
		int overlayWidth = Constants.HORIZONTAL_MARGIN + context.getConfig().graphWidth();
		int overlayHeight = context.getPanel().getBounds().height;
		
		graphics.setColor(new Color(101, 88, 65, backgroundTransparency));
		drawStartMessageLine("Get some gainz to start plotting!", overlayWidth, overlayHeight, -1, graphics);
		drawStartMessageLine("Alt+drag to move", overlayWidth, overlayHeight, 0, graphics);
		drawStartMessageLine("Change graph size in settings", overlayWidth, overlayHeight, 1, graphics);
	}
	
	private void drawStartMessageLine(String message,
									  int overlayWidth,
									  int overlayHeight,
									  int offset,
									  Graphics2D graphics)
	{
		int width = graphics.getFontMetrics().stringWidth(message);
		int x = overlayWidth / 2 - width / 2;
		
		int height = graphics.getFontMetrics().getHeight();
		int y = overlayHeight / 2 + height * offset + height / 2;
		
		graphics.drawString(message, x, y);
	}
}

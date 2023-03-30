package com.mhollink.gainzgraph.overlay.graph.components;

import com.mhollink.gainzgraph.config.Constants;
import com.mhollink.gainzgraph.experience.ExperienceDataManager;
import com.mhollink.gainzgraph.util.ColorUtils;
import com.mhollink.gainzgraph.util.ExperienceUtils;
import com.mhollink.gainzgraph.util.GraphUtils;

import java.awt.*;

public class GraphBackground
		implements DrawableComponent
{
	private final ExperienceDataManager experienceManager;
	
	public GraphBackground(ExperienceDataManager experienceManager)
	{
		this.experienceManager = experienceManager;
	}
	
	@Override
	public void draw(DrawableContext context)
	{
		Graphics2D graphics = context.getGraphics();
		int width = context.getConfig().graphWidth();
		int height = context.getConfig().graphHeight();
		
		int backgroundTransparency = ColorUtils.calculateAlphaValue(context.getConfig().graphBackgroundTransparency());
		
		graphics.setColor(new Color(101, 88, 65, backgroundTransparency));
		graphics.drawRect(Constants.MARGIN_LEFT, Constants.MARGIN_TOP, width, height);
		graphics.drawRect(Constants.MARGIN_LEFT - 1, Constants.MARGIN_TOP - 1, width + 2, height + 2);
		
		int verticalIncrement = height / Constants.GRAPH_LINES;
		for (int i = 0; i <= 5; i++) {
			int x = Constants.MARGIN_LEFT;
			int y = Constants.MARGIN_TOP + verticalIncrement * i;
			graphics.drawLine(x, y, x + width, y);
		}
		
		int maxYValue = GraphUtils.getMaxYValue(experienceManager.getMaxExpDrop());
		int increments = maxYValue / Constants.GRAPH_LINES;
		for (int i = 0; i <= Constants.GRAPH_LINES; i++) {
			String expAtSegment = ExperienceUtils.formatExperience(maxYValue - increments * i);
			int stringWidth = graphics.getFontMetrics().stringWidth(expAtSegment);
			int stringHeight = graphics.getFontMetrics().getHeight();
			graphics.drawString(
					expAtSegment,
					Constants.MARGIN_LEFT - stringWidth - 4,
					Constants.MARGIN_TOP + verticalIncrement * i + stringHeight / 2 - 1
			);
		}
	}
}

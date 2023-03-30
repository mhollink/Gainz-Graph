package com.mhollink.gainzgraph.overlay.graph.components;

import com.mhollink.gainzgraph.experience.ExperienceDataManager;
import com.mhollink.gainzgraph.util.GraphUtils;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Skill;

import java.awt.*;

import static com.mhollink.gainzgraph.config.Constants.MARGIN_LEFT;
import static com.mhollink.gainzgraph.config.Constants.MARGIN_TOP;
import static com.mhollink.gainzgraph.config.Constants.SKILLS;
import static com.mhollink.gainzgraph.config.GraphColorConfig.getSkillColor;

@Slf4j
public class GraphLines
		implements DrawableComponent
{
	private final ExperienceDataManager experienceManager;
	
	public GraphLines(ExperienceDataManager experienceManager)
	{
		this.experienceManager = experienceManager;
	}
	
	@Override
	public void draw(DrawableContext context)
	{
		int yMax = GraphUtils.getMaxYValue(experienceManager.getMaxExpDrop());
		Graphics2D graphics = context.getGraphics();
		int width = context.getConfig().graphWidth(), height = context.getConfig().graphHeight();
		for (Skill skill : SKILLS) {
			if (!experienceManager.getLastTrainedSkills().contains(skill)) {
				continue; // skip skills that are not being trained
			}
			graphics.setColor(getSkillColor(skill));
			PlotPoint prev = new PlotPoint(-1, -1);
			for (int x = 0; x < width; x++) {
				int exp = experienceManager.getExperienceAtPointInTime(skill, x);
				int y = GraphUtils.calculateYCoordinate(exp, height, yMax);
				
				if (prev.x != -1 && y >= 0) {
					drawPaddedLine(prev.x, height - prev.y, x, height - y, graphics);
				}
				
				prev = new PlotPoint(x, y);
			}
		}
	}
	
	private void drawPaddedLine(int x1, int y1, int x2, int y2, Graphics2D graphics)
	{
		graphics.drawLine(MARGIN_LEFT + x1, MARGIN_TOP + y1 - 1, MARGIN_LEFT + x2, MARGIN_TOP + y2 - 1);
		graphics.drawLine(MARGIN_LEFT + x1, MARGIN_TOP + y1, MARGIN_LEFT + x2, MARGIN_TOP + y2);
		graphics.drawLine(MARGIN_LEFT + x1, MARGIN_TOP + y1 + 1, MARGIN_LEFT + x2, MARGIN_TOP + y2 + 1);
	}
	
	private static class PlotPoint
	{
		int x;
		int y;
		
		public PlotPoint(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}

package com.mhollink.gainzgraph.overlay.graph;

import com.mhollink.gainzgraph.config.Constants;
import com.mhollink.gainzgraph.config.GraphConfig;
import com.mhollink.gainzgraph.experience.ExperienceDataManager;
import com.mhollink.gainzgraph.overlay.graph.components.DrawableComponent;
import com.mhollink.gainzgraph.overlay.graph.components.DrawableContext;
import com.mhollink.gainzgraph.overlay.graph.components.GraphBackground;
import com.mhollink.gainzgraph.overlay.graph.components.GraphEmptyText;
import com.mhollink.gainzgraph.overlay.graph.components.GraphLines;
import com.mhollink.gainzgraph.overlay.graph.components.PanelBackground;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

import java.awt.*;

public class ExperienceGraph
		implements LayoutableRenderableEntity
{
	
	private GraphConfig graphConfig;
	
	private ExperienceDataManager experienceManager;
	
	private DrawableComponent background;
	private DrawableComponent graphBackground;
	private DrawableComponent emptyText;
	private DrawableComponent expGraph;
	
	public ExperienceGraph(GraphConfig graphConfig, ExperienceDataManager experienceManager)
	{
		this.graphConfig = graphConfig;
		this.experienceManager = experienceManager;
		
		background = new PanelBackground();
		graphBackground = new GraphBackground(experienceManager);
		expGraph = new GraphLines(experienceManager);
		emptyText = new GraphEmptyText();
	}
	
	@Override
	public Rectangle getBounds()
	{
		int boundsWidth = Constants.HORIZONTAL_MARGIN + Constants.LEGEND_WIDTH + Constants.LEGEND_MARGIN + graphConfig.graphWidth();
		int boundsHeight = Constants.VERTICAL_MARGINS + graphConfig.graphHeight();
		
		return new Rectangle(boundsWidth, boundsHeight);
	}
	
	@Override
	public void setPreferredLocation(Point position)
	{
	}
	
	@Override
	public void setPreferredSize(Dimension dimension)
	{
	}
	
	@Override
	public Dimension render(Graphics2D graphics)
	{
		DrawableContext context = DrawableContext.createDrawableContext(graphics, graphConfig, this);
		DrawableComponent graphData = experienceManager.getLastTrainedSkills().size() > 0
									  ? expGraph
									  : emptyText;
		
		background.draw(context);
		graphBackground.draw(context);
		graphData.draw(context);
		
		return new Dimension(this.getBounds().width, this.getBounds().height);
	}
	
	private void displayExpRate()
	{
//		int endingSkillXp;
//		if (grapherPlugin.tickCount > 0) {
//			endingSkillXp = grapherPlugin.experienceTracker.getExperienceAtPointInTime(grapherPlugin.mostRecentSkillGained, grapherPlugin.tickCount - 1);
//		}
//		else {
//			endingSkillXp = grapherPlugin.experienceTracker.getExperienceAtPointInTime(grapherPlugin.mostRecentSkillGained, 0);
//		}
//		int startingSkillXp = grapherPlugin.experienceTracker.getExperienceAtPointInTime(grapherPlugin.mostRecentSkillGained, 0);
//		int xpGained = endingSkillXp - startingSkillXp;
//		long msPassed = System.currentTimeMillis() - grapherPlugin.startTime;
//		long secPassed = msPassed / 1000;
//		double xpPerSecond = (double) xpGained / secPassed;
//		double xpPerHour = xpPerSecond * 60 * 60;
//		String skillName = grapherPlugin.mostRecentSkillGained.getName();
//		DecimalFormat formatter = new DecimalFormat("###,###,###");
//		String skillInfoXpRate = formatter.format((int) xpPerHour);
//		String skillInfo = skillName + " XP/hr: " + skillInfoXpRate;
//		int skillInfoWidth = graphics.getFontMetrics()
//									 .stringWidth(skillInfo);
//		int skillInfoHeight = graphics.getFontMetrics()
//									  .getHeight();
//		//int skillInfoY = grapherPlugin.graphHeight+marginGraphTop+marginGraphBottom+bottomAxisTickMarkLength-skillInfoHeight/2;
//		int skillInfoY = bottomLeftGraphY + timeEndLabelHeight + marginTimeLabelTop;
//		int skillInfoX = marginGraphLeft + grapherPlugin.graphWidth / 2 - skillInfoWidth / 2;
////                graphics.drawString(skillInfo, skillInfoX, skillInfoY);
	}
	
	private void drawLegend()
	{
		// int legendSkillCount = plugin.currentlyGraphedSkills.size();
//		graphics.setColor(backgroundColorTrans);
//                graphics.fillRect(legendX, legendY, legendWidth, legendHeight);
//
//                //legend border box
//                graphics.setColor(graphLineColor);
//                graphics.drawRect(legendX, legendY, legendWidth, legendHeight);
//                graphics.drawRect(legendX-1, legendY-1, legendWidth+2, legendHeight+2);
//
//
//                //legend boxes and labels
//                int legendYOffset = marginGraphTop+2*marginLegendBoxTop-1;
//                for (int i = 0; i < grapherPlugin.skills.length; i++) {
//                    Skill theSkill = grapherPlugin.skills[i];
//                    if (grapherPlugin.isSkillShown(theSkill)) {
//                        //graphics.setColor(dataLineColors[i]);
//                        Color skillColor = grapherPlugin.xpGraphColorManager.getSkillColor(theSkill);
//                        graphics.setColor(skillColor);
//                        int legendBoxX = legendX + marginLegendBoxLeft;
//                        graphics.fillRect(legendBoxX, legendYOffset, legendBoxSize, legendBoxSize);
//                        graphics.setColor(Color.BLACK);
//                        graphics.drawRect(legendBoxX, legendYOffset, legendBoxSize, legendBoxSize);
//                        legendYOffset += legendBoxSize + marginLegendBoxBottom;
//
//                        graphics.setColor(graphLineColor);
//                        String skillName = theSkill.getName();
//                        int skillNameHeight = graphics.getFontMetrics().getHeight();
//                        int skillNameX = legendBoxX + legendBoxSize + marginLegendBoxRight;
//                        int skillNameY = legendYOffset;
//                        graphics.drawString(skillName, skillNameX, skillNameY);
//                    }
//                }
//            }
	}
	
	private void somethingElse()
	{
//		//bottom axis tick marks
//		graphics.setColor(graphLineColor);
//		int bottomLeftGraphX = marginGraphLeft;
//		int bottomLeftGraphY = marginGraphTop + plugin.graphHeight;
//		graphics.drawLine(bottomLeftGraphX, bottomLeftGraphY, bottomLeftGraphX, bottomLeftGraphY + bottomAxisTickMarkLength);
//		graphics.drawLine(bottomLeftGraphX - 1, bottomLeftGraphY, bottomLeftGraphX - 1, bottomLeftGraphY + bottomAxisTickMarkLength);
//		int bottomRightGraphX = bottomLeftGraphX + plugin.graphWidth;
//		graphics.drawLine(bottomRightGraphX, bottomLeftGraphY, bottomRightGraphX, bottomLeftGraphY + bottomAxisTickMarkLength);
//		graphics.drawLine(bottomRightGraphX + 1, bottomLeftGraphY, bottomRightGraphX + 1, bottomLeftGraphY + bottomAxisTickMarkLength);
//
//		long timePassed = plugin.currentTime - plugin.startTime;
//		String timeStartLabel = "0";
//		int timeStartLabelWidth = graphics.getFontMetrics()
//										  .stringWidth(timeStartLabel);
//		int timeStartLabelHeight = graphics.getFontMetrics()
//										   .getHeight();
//		graphics.drawString(timeStartLabel, bottomLeftGraphX - timeStartLabelWidth / 2, bottomLeftGraphY + timeStartLabelHeight + marginTimeLabelTop);
//
//		//int secondsPassed = (int)timePassed/1000;
//		//int timePassedHours = secondsPassed/(60*60);
//		//int secondsLeft = secondsPassed%(60*60);
//		//int timePassedMinutes = secondsLeft/60;
//		//int timePassedSeconds = secondsLeft%60;
//
//		//String timeEndLabel = timePassedHoursString + ":" + timePassedMinutesString + ":" + timePassedSecondsString;
//
//		//String timeEndLabel = formatTime(timePassedHours, timePassedMinutes, timePassedSeconds);
//		String timeEndLabel = formatTime(timePassed);
//            /*
//            if (timePassedHours > 0)
//                timeEndLabel += timePassedHours + ":";
//            if (timePassedMinutes > 0 || timePassedHours > 0) {
//                if (timePassedMinutes < 10 && timePassedHours > 0)
//                    timeEndLabel += "0";
//                timeEndLabel += timePassedMinutes + ":";
//            }
//            if (timePassedSeconds < 10 && (timePassedMinutes > 0|| timePassedHours > 0))
//                timeEndLabel += "0";
//            timeEndLabel += timePassedSeconds;
//            */
//
//            /*
//            int secondsPassed = (int)(timePassed/1000);
//            int timePassedMinutes = secondsPassed/60;
//            int secondsLeft = secondsPassed%60;
//            String secondsLeftString = Integer.toString(secondsLeft);
//            if (secondsLeft < 10) {
//                secondsLeftString = "0" + secondsLeftString;
//            }
//            String timeEndLabel = timePassedMinutes + ":" + secondsLeftString;
//            */
//
//		int timeEndLabelWidth = graphics.getFontMetrics()
//										.stringWidth(timeEndLabel);
//		int timeEndLabelHeight = graphics.getFontMetrics()
//										 .getHeight();
//		graphics.drawString(timeEndLabel, bottomRightGraphX - timeEndLabelWidth / 2, bottomLeftGraphY + timeEndLabelHeight + marginTimeLabelTop);
//
	}
}

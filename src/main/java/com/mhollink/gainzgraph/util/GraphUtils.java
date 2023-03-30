package com.mhollink.gainzgraph.util;

import java.util.Arrays;

public final class GraphUtils
{
	
	private static int[] xpGraphMaxValues = {
			100, 250, 500, 1000, 2000, 3000, 4000, 5000, 7500, 10_000, 12_500, 15_000, 20_000, 30_000, 40_000, 50_000,
			75_000, 100_000, 150_000, 200_000, 300_000, 400_000, 500_000, 750_000, 1_000_000,
	};
	
	public static int getMaxYValue(int highestExpDrop)
	{
		return Arrays.stream(xpGraphMaxValues).filter(value -> value > highestExpDrop).findFirst().getAsInt();
	}
	
	public static int calculateYCoordinate(int value, int graphHeight, int yMax)
	{
		return graphHeight * value / yMax;
	}

//
//	private GainzGraphPlugin plugin;
//	private Map<Skill, List<Integer>> skillGraphPointsMap = new HashMap<>();
//	public Map<Skill, Boolean> isSkillShownMap = new HashMap<>();
//
//	public int maxVertAxisValue = 0;
//

//
//	public Graph(GainzGraphPlugin plugin)
//	{
//		this.plugin = plugin;
//
//		SKILLS.forEach(skill -> {
//			List<Integer> newGraphPointList = new ArrayList<>();
//			skillGraphPointsMap.put(skill, newGraphPointList);
//			isSkillShownMap.put(skill, false);
//		});
//	}
//
//	public boolean isSkillShown(Skill theSkill)
//	{
//		return isSkillShownMap.get(theSkill);
//	}
//
//	public int getGraphPointData(
//			Skill skillToGraph,
//			int x)
//	{
//		List<Integer> skillGraphData = skillGraphPointsMap.get(skillToGraph);
//		return skillGraphData.size() == 0
//			   ? plugin.getConfig().graphHeight()
//			   : skillGraphData.get(x);
//	}
//
//	public List<Integer> getGraphPointDataList(Skill theSkill)
//	{
//		return skillGraphPointsMap.get(theSkill);
//	}
//
//	public void update()
//	{
//		int maxXpGained = -1;
//
//		for (int i = 0; i < Skill.values().length; i++) {
//
//			Skill skillToCheck = Skill.values()[i];
//
//			if (plugin.isSkillShown(skillToCheck)) {
//				int skillMinXp = plugin.getExperienceDataManager().getExperienceAtPointInTime(skillToCheck, 0);
//				//System.out.println(grapherPlugin.tickCount);
//				int skillMaxXp = plugin.getExperienceDataManager().getExperienceAtPointInTime(skillToCheck, plugin.tickCount);
//				int skillXpGained = skillMaxXp - skillMinXp;
//				if (maxXpGained == -1 || skillXpGained > maxXpGained) {
//					maxXpGained = skillXpGained;
//				}
//			}
//		}
//
//		boolean maxXpFound = false;
//		int maxXpIndex = 0;
//		while (!maxXpFound) {
//			if (maxXpGained <= xpGraphMaxValues[maxXpIndex]) {
//				maxXpFound = true;
//				//System.out.println(xpGraphMaxValues[maxXpIndex]);
//			}
//			else {
//				maxXpIndex++;
//			}
//		}
//		maxVertAxisValue = xpGraphMaxValues[maxXpIndex];
//
//		for (int i = 0; i < Skill.values().length; i++) {
//
//			Skill skillToUpdate = Skill.values()[i];
//
//			ArrayList<Integer> newGraphPointList = new ArrayList<Integer>();
//
//			for (int x = 0; x < plugin.getConfig().graphWidth(); x++) {
//
//				double ratioAcrossGraph = (double) x / ((double) plugin.getConfig().graphWidth());
//
//				int dataIndex = (int) (Math.floor(ratioAcrossGraph * (plugin.tickCount + 1)));
//
//				//int ceilDataIndex = (int)(Math.ceil(ratioAcrossGraph*(grapherPlugin.tickCount)));
//				//int floorDataIndex = (int)(Math.floor(ratioAcrossGraph*(grapherPlugin.tickCount)));
//				//System.out.println(ceilDataIndex + ", " + floorDataIndex);
//
//				int dataXpValue = plugin.getExperienceDataManager().getExperienceAtPointInTime(skillToUpdate, dataIndex);
//				if (x == 0) {
//					dataXpValue = plugin.getExperienceDataManager().getExperienceAtPointInTime(skillToUpdate, 0);
//				}
//				if (x == plugin.getConfig().graphWidth() - 1) {
//					dataXpValue = plugin.getExperienceDataManager().getMostRecentXp(skillToUpdate);
//				}
//
//				int dataXpMinValue = plugin.getExperienceDataManager().getExperienceAtPointInTime(skillToUpdate, 0);
//				int dataXpGained = dataXpValue - dataXpMinValue;
//
//				double ratioVertical = dataXpGained / (double) maxVertAxisValue;
//				int y = plugin.getConfig().graphHeight() - (int) ((double) plugin.getConfig().graphHeight() * ratioVertical);
//
//				//if (x == grapherPlugin.graphWidth-1) {
//				//
//				//    dataXpValue = grapherPlugin.getClient().getSkillExperience(skillToUpdate);
//				//
//				//}
//
//				newGraphPointList.add(y);
//			}
//
//			skillGraphPointsMap.put(skillToUpdate, newGraphPointList);
//		}
//	}
}
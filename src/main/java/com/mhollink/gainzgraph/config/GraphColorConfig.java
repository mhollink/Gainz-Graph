package com.mhollink.gainzgraph.config;

import net.runelite.api.Skill;

import javax.inject.Singleton;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public final class GraphColorConfig {

    private static final Map<Skill, Color> colorMap = new HashMap<>() {{
        put(Skill.ATTACK, new Color(93, 17, 9));
        put(Skill.STRENGTH, new Color(12, 108, 71));
        put(Skill.DEFENCE, new Color(98, 115, 173));
        put(Skill.RANGED, new Color(78, 100, 24));
        put(Skill.PRAYER, new Color(190, 180, 179));
        put(Skill.MAGIC, new Color(6, 10, 100));
        put(Skill.RUNECRAFT, new Color(200, 128, 50));
        put(Skill.CONSTRUCTION, new Color(77, 66, 52));
        put(Skill.HITPOINTS, new Color(185, 38, 21));
        put(Skill.AGILITY, new Color(32, 33, 89));
        put(Skill.HERBLORE, new Color(41, 179, 83));
        put(Skill.CRAFTING, new Color(136, 104, 27));
        put(Skill.FLETCHING, new Color(0, 51, 52));
        put(Skill.SLAYER, new Color(32, 29, 29));
        put(Skill.HUNTER, new Color(149, 138, 119));
        put(Skill.MINING, new Color(66, 66, 52));
        put(Skill.SMITHING, new Color(121, 121, 113));
        put(Skill.FISHING, new Color(93, 116, 138));
        put(Skill.COOKING, new Color(70, 27, 82));
        put(Skill.FIREMAKING, new Color(192, 102, 24));
        put(Skill.WOODCUTTING, new Color(73, 133, 13));
        put(Skill.FARMING, new Color(149, 174, 99));
    }};

    public static Color getSkillColor(Skill skill) {
        return colorMap.getOrDefault(skill, Color.MAGENTA);
    }

}
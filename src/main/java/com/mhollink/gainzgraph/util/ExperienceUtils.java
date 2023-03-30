package com.mhollink.gainzgraph.util;

public final class ExperienceUtils
{
	public static String formatExperience(int experience)
	{
		if (experience < 1000) {
			return Integer.toString(experience);
		}
		
		if (experience < 1000000) {
			return getExperienceString(experience, 1000, 'K');
		}
		
		return getExperienceString(experience, 1000000, 'M');
	}
	
	private static String getExperienceString(int experience, int something, char suffix)
	{
		int xp = experience / something;
		int decimalPart = experience % something;
		String result = Integer.toString(xp);
		if (decimalPart > 0) {
			result = result + "." + decimalPart;
			while (result.charAt(result.length() - 1) == '0') {
				result = result.substring(0, result.length() - 1);
			}
		}
		return result + suffix;
	}
}

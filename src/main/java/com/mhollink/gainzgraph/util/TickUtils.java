package com.mhollink.gainzgraph.util;

public final class TickUtils
{
	public static String formatTime(long timePassed)
	{
		int secondsPassed = (int) timePassed / 1000;
		int hours = secondsPassed / (60 * 60);
		int secondsLeft = secondsPassed % (60 * 60);
		int minutes = secondsLeft / 60;
		int seconds = secondsLeft % 60;
		
		String result = "";
		if (hours > 0) {
			result += hours + ":";
		}
		if (minutes > 0 || hours > 0) {
			if (minutes < 10 && hours > 0) {
				result += "0";
			}
			result += minutes + ":";
		}
		if (seconds < 10 && (minutes > 0 || hours > 0)) {
			result += "0";
		}
		result += seconds;
		return result;
	}
}

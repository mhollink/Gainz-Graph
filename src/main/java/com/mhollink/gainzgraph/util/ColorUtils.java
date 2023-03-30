package com.mhollink.gainzgraph.util;

public final class ColorUtils
{
	public static int calculateAlphaValue(int transparencyPercentage)
	{
		return (int) (255 * ((double) transparencyPercentage / (double) 100));
	}
}

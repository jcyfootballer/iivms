package com.dlx.common.util;

public class ColorUtil {
	private static final int TextShade = 0x0000BEAD; // 渐变开始时的颜色
	private static final int TransEnd = 0x0000AD0C; // 渐变结束时的颜色

	/**********************************
	 * 
	 * 输入一个颜色,将它拆成三个部分: 红色,绿色和蓝色
	 * 
	 **********************************/
	public static int[] retrieveRGBComponent(int color) {
		int[] rgb = new int[3];
		rgb[0] = (color & 0x00ff0000) >> 16;
		rgb[1] = (color & 0x0000ff00) >> 8;
		rgb[2] = (color & 0x000000ff);
		return rgb;
	}

	/**********************************
	 * 
	 * color1是浅色,color2是深色,实现渐变 steps是指在多大的区域中渐变, 在左右渐变是steps就是宽 在上下渐变时steps就是高
	 * 0xFFFF00
	 **********************************/
	public static int[] generateTransitionalColor(int color1, int color2,
			int steps) {
		int[] color1RGB = retrieveRGBComponent(color1);
		int[] color2RGB = retrieveRGBComponent(color2);
		if (steps < 3 || color1RGB == null || color2RGB == null)
			return null;
		int[] colors = new int[steps];
		colors[0] = color1;
		colors[colors.length - 1] = color2;
		steps = steps - 2;
		int redDiff = color2RGB[0] - color1RGB[0];
		int greenDiff = color2RGB[1] - color1RGB[1];
		int blueDiff = color2RGB[2] - color1RGB[2];
		// from the second to the last second.
		for (int i = 1; i < colors.length - 1; i++) {
			colors[i] = generateFromRGBComponent(new int[] {
					color1RGB[0] + redDiff * i / steps,
					color1RGB[1] + greenDiff * i / steps,
					color1RGB[2] + blueDiff * i / steps });
		}
		return colors;
	}

	/**********************************
	 * 
	 * 
	 * 红色,绿色和蓝色三色组合
	 * 
	 **********************************/
	public static int generateFromRGBComponent(int[] rgb) {
		if (rgb == null || rgb.length != 3 || rgb[0] < 0 || rgb[0] > 255
				|| rgb[1] < 0 || rgb[1] > 255 || rgb[2] < 0 || rgb[2] > 255)
			return 0xfffff;
		return rgb[0] << 16 | rgb[1] << 8 | rgb[2];
	}
}

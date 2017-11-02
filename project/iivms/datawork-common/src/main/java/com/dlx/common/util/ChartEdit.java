package com.dlx.common.util;

import org.dom4j.Element;

public class ChartEdit {
	public static Element transparency(Element chart) {
		chart.addAttribute("baseFontColor", "FFFFFF"); // 字体颜色
		chart.addAttribute("canvasBgColor", "000000");// 画布背景
		chart.addAttribute("palette", "3");// 画布风格
		chart.addAttribute("legendBgColor", "000000");// 图例背景
		chart.addAttribute("toolTipBgColor", "000000");// 图形上提示框背景
		chart.addAttribute("bgAlpha", "transparency");// flash背景为透明
		chart.addAttribute("bgColor", "000000");// flash背景为黑色
		chart.addAttribute("plotgradientcolor", "");// 取消透明色
		chart.addAttribute("showplotborder", "0");// 显示小区边界
		return chart;
	}

	public static Element transparency_white(Element chart) {
		// chart.addAttribute("palette", "3");// 画布风格
		chart.addAttribute("baseFontColor", "000000"); // 字体颜色
		chart.addAttribute("legendBgColor", "FFF4CA");// 图例背景
		chart.addAttribute("toolTipBgColor", "FFF4CA");// 图形上提示框背景
		chart.addAttribute("bgAlpha", "transparency");// flash背景为透明
		chart.addAttribute("bgColor", "F5F9FA");// flash背景为白色
		chart.addAttribute("plotgradientcolor", "");// 取消透明色
		chart.addAttribute("showplotborder", "0");// 显示小区边界

		return chart;
	}

	public static Element applyPaletteWhite(Element chart) {
		chart.addAttribute("palette", "3");// 画布风格
		chart.addAttribute("baseFontColor", "000000"); // 字体颜色
		chart.addAttribute("legendBgColor", "FFF4CA");// 图例背景
		chart.addAttribute("toolTipBgColor", "FFF4CA");// 图形上提示框背景
		chart.addAttribute("bgAlpha", "transparency");// flash背景为透明
		chart.addAttribute("bgColor", "FFFFFF");// flash背景为白色
		chart.addAttribute("plotgradientcolor", "");// 取消透明色
		chart.addAttribute("showplotborder", "0");// 显示小区边界
		return chart;
	}

	public static Element applyPaletteBlack(Element chart) {
		chart.addAttribute("baseFontColor", "FFFFFF"); // 字体颜色
		chart.addAttribute("canvasBgColor", "3C485F");// 画布背景
		chart.addAttribute("palette", "3");// 画布风格
		chart.addAttribute("legendBgColor", "3C485F");// 图例背景
		chart.addAttribute("toolTipBgColor", "3C485F");// 图形上提示框背景
		chart.addAttribute("bgAlpha", "transparency");// flash背景为透明
		chart.addAttribute("bgColor", "051641");// flash背景为黑色
		chart.addAttribute("plotgradientcolor", "");// 取消透明色
		chart.addAttribute("showplotborder", "0");// 显示小区边界
		chart.addAttribute("borderColor", "FFFFFF");//
		// chart.addAttribute("borderColor", "051641");//
		// chart.addAttribute("showBorder", "1");//
		return chart;
	}

	public static Element ChartFont(Element chart) {
		Element styles = chart.addElement("styles");
		Element definition = styles.addElement("definition");
		Element style = definition.addElement("style");
		style.addAttribute("name", "myCaptionFont");
		style.addAttribute("type", "font");
		style.addAttribute("font", "宋体");
		style.addAttribute("size", "16");
		style.addAttribute("bold", "1");

		style = definition.addElement("style");
		style.addAttribute("name", "myYnameFont");
		style.addAttribute("type", "font");
		style.addAttribute("font", "宋体");
		style.addAttribute("size", "13");
		style.addAttribute("bold", "0");

		Element application = styles.addElement("application");
		Element apply = application.addElement("apply");
		apply.addAttribute("toObject", "Caption");
		apply.addAttribute("styles", "myCaptionFont");

		apply = application.addElement("apply");
		apply.addAttribute("toObject", "yAxisName");
		apply.addAttribute("styles", "myYnameFont");

		apply = application.addElement("apply");
		apply.addAttribute("toObject", "xAxisName");
		apply.addAttribute("styles", "myYnameFont");
		chart.addAttribute("baseFontSize", "12");
		return chart;
	}

	/**
	 * 电压分析--合格率
	 * 
	 * @author wangzhixin
	 * @date 2012-5-29
	 * @param chart
	 * @return
	 */
	public static Element AngularGauge(Element chart, String v1, String v2) {
		// chart.addAttribute("manageResize", "1");
		// chart.addAttribute("origW", "400");
		// chart.addAttribute("origH", "250");
		// chart.addAttribute("manageValueOverlapping", "1");
		// chart.addAttribute("autoAlignTickValues", "1");
		// chart.addAttribute("bgColor", "AEC0CA,FFFFFF");
		// chart.addAttribute("fillAngle", "45");
		chart.addAttribute("upperLimit", "100");
		chart.addAttribute("lowerLimit", "70");
		chart.addAttribute("gaugeStartAngle", "180");
		chart.addAttribute("gaugeEndAngle", "0");
		chart.addAttribute("palette", "1");
		// chart.addAttribute("gaugeOuterRadius", "140");
		// chart.addAttribute("gaugeOriginX", "205");
		// chart.addAttribute("gaugeOriginY", "206");
		// chart.addAttribute("gaugeInnerRadius", "2");
		// chart.addAttribute("formatNumberScale", "1");
		chart.addAttribute("numberSuffix", "%");
		chart.addAttribute("tickValueDistance", "20");
		chart.addAttribute("showValue", "1");
		// chart.addAttribute("pivotRadius", "17");
		// chart.addAttribute("showPivotBorder", "1");
		// chart.addAttribute("pivotBorderColor", "000000");
		// chart.addAttribute("pivotBorderThickness", "5");
		// chart.addAttribute("pivotFillMix", "FFFFFF,000000");
		// chart.addAttribute("tickValueDistance", "10");
		Element colorRange = chart.addElement("colorRange");
		Element color = colorRange.addElement("color");
		Element color1 = colorRange.addElement("color");
		Element color3 = colorRange.addElement("color");
		color.addAttribute("minValue", "70");
		color.addAttribute("maxValue", v1);
		color.addAttribute("code", "FF654F");
		color1.addAttribute("minValue", v1);
		color1.addAttribute("maxValue", v2);
		color1.addAttribute("code", "F6BD0F");
		color3.addAttribute("minValue", v2);
		color3.addAttribute("maxValue", "100");
		color3.addAttribute("code", "8BBA00");
		// Element annotations=chart.addElement("annotations");
		// Element annotationGroup=annotations.addElement("annotationGroup");
		// annotationGroup.addAttribute("x", "235");
		// annotationGroup.addAttribute("y", "237.5");
		// Element annotation=annotationGroup.addElement("annotation");
		// Element annotation1=annotationGroup.addElement("annotation");
		// annotation.addAttribute("type", "circle");
		// annotation.addAttribute("x", "0");
		// annotation.addAttribute("y", "2.5");
		// annotation.addAttribute("radius", "150");
		// annotation.addAttribute("startAngle", "0");
		// annotation.addAttribute("endAngle", "180");
		// annotation.addAttribute("fillPattern", "linear");
		// annotation.addAttribute("fillAsGradient", "1");
		// annotation.addAttribute("fillColor", "dddddd,666666");
		// annotation.addAttribute("fillAlpha", "100,100");
		// annotation.addAttribute("fillRatio", "50,50");
		// annotation.addAttribute("fillAngle", "0");
		// annotation.addAttribute("showBorder", "1");
		// annotation.addAttribute("borderColor", "444444");
		// annotation.addAttribute("borderThickness", "2");
		//
		// annotation1.addAttribute("type", "circle");
		// annotation1.addAttribute("x", "0");
		// annotation1.addAttribute("y", "0");
		// annotation1.addAttribute("radius", "145");
		// annotation1.addAttribute("startAngle", "0");
		// annotation1.addAttribute("endAngle", "180");
		// annotation1.addAttribute("fillPattern", "linear");
		// annotation1.addAttribute("fillAsGradient", "1");
		// annotation1.addAttribute("fillColor", "666666,ffffff");
		// annotation1.addAttribute("fillAlpha", "100,100");
		// annotation1.addAttribute("fillRatio", "50,50");
		// annotation1.addAttribute("fillAngle", "0");
		return chart;
	}

	/**
	 * 大屏幕展示字体设置
	 * 
	 * @author wangzhixin
	 * @date 2012-9-7
	 * @param chart
	 * @return
	 */
	public static Element applyLargeFont_New(Element chart) {
		// 定义样式
		Element stylesEle = chart.addElement("styles");
		// 定义
		Element definitionElement = stylesEle.addElement("definition");
		// 应用于
		Element applicationElement = stylesEle.addElement("application");
		// 数值显示样式
		Element styleElement = definitionElement.addElement("style");
		styleElement.addAttribute("name", "myDataValueColor");
		styleElement.addAttribute("type", "font");
		// styleElement.addAttribute("color", "FF0000");
		styleElement.addAttribute("font", "微软雅黑");
		styleElement.addAttribute("size", "16");
		styleElement.addAttribute("bold", "0");

		Element applyElement = applicationElement.addElement("apply");
		applyElement.addAttribute("toObject", "DataValues");
		applyElement.addAttribute("styles", "myDataValueColor");
		// 标题样式
		Element captionFontStyleElement = definitionElement.addElement("style");
		captionFontStyleElement.addAttribute("name", "myCaptionFont");
		captionFontStyleElement.addAttribute("type", "font");
		captionFontStyleElement.addAttribute("font", "SimSun");
		captionFontStyleElement.addAttribute("font", "微软雅黑");
		captionFontStyleElement.addAttribute("size", "20");
		captionFontStyleElement.addAttribute("bold", "1");

		Element captionApplyElement = applicationElement.addElement("apply");
		captionApplyElement.addAttribute("toObject", "Caption");
		captionApplyElement.addAttribute("styles", "myCaptionFont");
		chart.addAttribute("baseFontSize", "17");
		chart.addAttribute("outCnvBaseFont", "微软雅黑");
		return chart;
	}

	public Element editChartOtherTwo(Element chart, String value,
			String maxValue) {
		String temp = "";
		if (null != maxValue && !maxValue.equals("")) {
			temp = Math.round((Double.parseDouble(maxValue) * 1.2)) + "";
		}
		chart.addAttribute("plotFillColor", "00A8EF");
		chart.addAttribute("lowerLimit", "0");
		chart.addAttribute("plotFillAlpha", "90");
		chart.addAttribute("bgColor", "FFFFFF");
		chart.addAttribute("targetColor", "1B9889");
		// chart.addAttribute("upperLimit","5000");
		chart.addAttribute("palette", "2");
		chart.addAttribute("formatNumberScale", "1");
		// chart.addAttribute("numberSuffix", "W");
		chart.addAttribute("baseFontColor", "001760");
		Element colorRange = chart.addElement("colorRange");
		Element color = colorRange.addElement("color");
		color.addAttribute("minValue", "0");
		color.addAttribute("maxValue", "0");
		color.addAttribute("color", "A6A6A6");
		Element color1 = colorRange.addElement("color");
		color1.addAttribute("minValue", "0");
		color1.addAttribute("maxValue", "0");
		color1.addAttribute("color", "CCCCCC");
		Element color2 = colorRange.addElement("color");
		color2.addAttribute("minValue", "0");

		color2.addAttribute("maxValue", temp);
		color2.addAttribute("color", "E1E1E1");

		Element valuetext = chart.addElement("value");
		valuetext.addText(value);
		Element target = chart.addElement("target");
		target.addText(maxValue);
		return chart;
	}

	public static void applySetColorWithType(Element set, String codename) {
		if ("煤电".equals(codename) || "0".equals(codename)) {
			set.addAttribute("color", "#FEBCAB");
		} else if ("气电".equals(codename) || "1".equals(codename)) {
			set.addAttribute("color", "#B3DAF8");
		} else if ("水电".equals(codename) || "3".equals(codename)) {
			set.addAttribute("color", "#CBFDC4");
		} else if ("油电".equals(codename) || "2".equals(codename)) {
			set.addAttribute("color", "#F6C11D");
		} else if ("风电".equals(codename) || "6".equals(codename)) {
			set.addAttribute("color", "#92BE0F");
		} else if ("核电".equals(codename) || "5".equals(codename)) {
			set.addAttribute("color", "#945194");
		} else if ("蓄能".equals(codename) || "4".equals(codename)) {
			set.addAttribute("color", "#628C33");
		} else {
			set.addAttribute("color", "#FF9451");
		}
	}
}

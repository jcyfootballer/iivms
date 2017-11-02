package com.dlx.common.util;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CommonMethod {

	Calendar calendar = GregorianCalendar.getInstance();

	// 获取昨天日期,返回格式如:2008-03-28
	public static String getLastDay(Date d_date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d_date);
		gc.add(5, -1);// 减一天
		gc.set(gc.get(gc.YEAR), gc.get(gc.MONTH), gc.get(gc.DATE));
		return sdf.format(gc.getTime());
	}

	// 获取昨天日期,返回格式如:2008-03-28
	public static String getOneDay(Date d_date, int days)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d_date);
		gc.add(5, days);// 减/加n天
		gc.set(gc.get(gc.YEAR), gc.get(gc.MONTH), gc.get(gc.DATE));
		return sdf.format(gc.getTime());
	}

	// 将日期型转换成字符型
	public static String fromDateToStr(Date d_date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d_date);
	}

	// 将字符型转换成日期型
	public static Date fromStrToDate(String dateString, String fromFormat) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat(fromFormat);
		// java.text.DateFormat formatter=new
		// java.text.SimpleDateFormat("yyyy-MM-dd   HH:MM:SS");
		df.setTimeZone(gc.getTimeZone());
		df.setLenient(false);
		Date date = df.parse(dateString, new ParsePosition(0));
		return date;
	}

	public static Date fromDateString1(String dateString, String fromFormat) {
		GregorianCalendar gc = new GregorianCalendar();
		// SimpleDateFormat df = new SimpleDateFormat(fromFormat); //yyyy-MM-dd
		// HH:mm:ss
		java.text.DateFormat df = new SimpleDateFormat(fromFormat);
		// df.setTimeZone(gc.getTimeZone());
		// df.setLenient(false);
		Date date = df.parse(dateString, new ParsePosition(0));
		return date;
	}

	// 获取星期几
	public static String getWeekOfDate(Date d_date) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		// String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d_date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];

	}

	// 获取某日所在月的第一天和次月的第一天
	public String[] getFirstAndLastDay(Date d_date) throws Exception {
		int i_year, i_month;
		String[] s_day = { "", "" };// 其中:s_day[0]当月首日,s_day[1]次月首日

		i_year = getYear(d_date);
		i_month = getMonth(d_date);

		if (i_month < 10)
			s_day[0] = i_year + "-0" + i_month + "-01";
		else
			s_day[0] = i_year + "-" + i_month + "-01";

		if (i_month == 12) {
			i_year = i_year + 1;
			s_day[1] = i_year + "-01-01";
		} else {
			i_month = i_month + 1;
			if (i_month < 10)
				s_day[1] = i_year + "-0" + i_month + "-01";
			else
				s_day[1] = i_year + "-" + i_month + "-01";
		}

		return s_day;

	}

	// 获取年度
	public int getYear(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.YEAR);
	}

	// 获取月份
	public int getMonth(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	// 获取天
	public int getDate(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.DATE);
	}

	// 获取小时
	public int getHour(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	// 获取分钟
	public int getMinute(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.MINUTE);
	}

	// 获取秒
	public int getSecond(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.SECOND);
	}

	// 获取AM_PM
	public int getAMPM(Date d_date) throws Exception {
		calendar.setTime(d_date);
		return calendar.get(Calendar.AM_PM);
	}

	public static int getDateCountOfMonth(int year, int month) {
		GregorianCalendar gc = new GregorianCalendar();

		gc.set(Calendar.YEAR, year);
		gc.set(Calendar.MONTH, month - 1);

		return gc.getActualMaximum(Calendar.DATE);
	}

	public static int daysCount2(int year, int month) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar(year,
				month - 1, 1);
		return gregorianCalendar.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	public static boolean isNull(String s) {
		return s == null || s.trim().equals("");
	}

	public static String getPointTime(int point) {
		String time = "";
		time = String.valueOf(point / 4);
		time = time + ":" + String.valueOf(point % 4 * 15);
		return time;
	}

	/**
	 * 保留两位小数
	 * 
	 * @param d
	 * @return
	 */
	public static double formatDoubleToFloat(double d) {
		BigDecimal b = new BigDecimal(d);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	// 将字符型转换成日期型

}
/**
 * 
 */
package com.dlx.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author jiangcy
 *
 */
public class CommonUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//2017/09/06 09:00:33
	public static String formatDate(Date date) throws ParseException {
		synchronized (sdf) {
			return sdf.format(date);
		}
	}

	public static Date parse(String strDate) throws ParseException {
		synchronized (sdf) {
			return sdf.parse(strDate);
		}
	}

	private static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	
	public static String formatDateTime(Date date) throws ParseException {
		synchronized (sdfTime) {
			return sdfTime.format(date);
		}
	}

	public static Date parseDateTime(String strDate) throws ParseException {
		synchronized (sdfTime) {
			return sdfTime.parse(strDate);
		}
	}

	private static SimpleDateFormat sdfDateTimePath = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public static String formatDateTimePath(Date date) throws ParseException {
		synchronized (sdfDateTimePath) {
			return sdfDateTimePath.format(date);
		}
	}

	public static Date parseDateTimePath(String strDate) throws ParseException {
		synchronized (sdfDateTimePath) {
			return sdfDateTimePath.parse(strDate);
		}
	}

	private static SimpleDateFormat sdfDatePath = new SimpleDateFormat(
			"yyyyMMdd");

	public static String formatDatePath(Date date) throws ParseException {
		synchronized (sdfDatePath) {
			return sdfDatePath.format(date);
		}
	}

	public static Date parseDatePath(String strDate) throws ParseException {
		synchronized (sdfDatePath) {
			return sdfDatePath.parse(strDate);
		}
	}

	public static boolean isNull(String s) {
		return s == null || s.trim().equals("");
	}

	public static String addZero(double v) {
		StringBuffer s = null;
		String temp = String.valueOf(v);
		int point = temp.indexOf(".");
		int length = temp.length();
		int n = length - 1 - point;

		if (n > 0) {
			s = new StringBuffer(temp);
			for (int i = 0; i < n; i++) {
				s.append(0);
			}
			return s.toString();
		} else {
			return temp;
		}
	}

	/*
	 * 获取指定分钟为步长的数据
	 */
	public static Date[] getDays(final Date startDate, final Date endDate,
			final int minuteStep) {
		List<Date> dayList = new ArrayList<Date>();
		if (null != startDate && null != endDate && startDate.before(endDate)
				&& minuteStep > 0) {

			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(startDate);
			gregoriancalendar.set(Calendar.SECOND, 0);
			gregoriancalendar.set(Calendar.MILLISECOND, 0);
			int mi = gregoriancalendar.get(Calendar.MINUTE);
			if (mi % minuteStep != 0) {
				mi = mi + minuteStep;

			}
			gregoriancalendar
					.set(Calendar.MINUTE, mi / minuteStep * minuteStep);

			Date newDate = gregoriancalendar.getTime();
			while (newDate.getTime() <= endDate.getTime()) {
				dayList.add(newDate);
				gregoriancalendar.add(Calendar.MINUTE, minuteStep);
				newDate = gregoriancalendar.getTime();
			}
		}
		Date[] dayArray = new Date[dayList.size()];
		dayList.toArray(dayArray);
		return dayArray;
	}

	/**
	 * 
	 * 获取开始日期和结束日期之间的日期，
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * 
	 * @return 包含开始日期在内小于结束日期的日期集合，不包含结束日期
	 */
	public static Date[] getDays(final Date startDate, final Date endDate) {
		List<Date> dayList = new ArrayList<Date>();
		if (null != startDate && null != endDate) {

			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(startDate);
			gregoriancalendar.set(Calendar.HOUR_OF_DAY, 0);
			gregoriancalendar.set(Calendar.MINUTE, 0);
			gregoriancalendar.set(Calendar.SECOND, 0);
			gregoriancalendar.set(Calendar.MILLISECOND, 0);

			Date sDate = gregoriancalendar.getTime();

			GregorianCalendar gregoriancalendar2 = new GregorianCalendar();
			gregoriancalendar2.setTime(endDate);
			gregoriancalendar2.set(Calendar.HOUR_OF_DAY, 0);
			gregoriancalendar2.set(Calendar.MINUTE, 0);
			gregoriancalendar2.set(Calendar.SECOND, 0);
			gregoriancalendar2.set(Calendar.MILLISECOND, 0);

			Date eDate = gregoriancalendar2.getTime();

			do {
				dayList.add(sDate);
				gregoriancalendar.add(Calendar.DATE, 1);
				sDate = gregoriancalendar.getTime();
			} while (sDate.getTime() < eDate.getTime());

		}
		Date[] dayArray = new Date[dayList.size()];
		dayList.toArray(dayArray);
		return dayArray;
	}

	/**
	 * 获取开始日期和结束日期之间按步长分割的日期集合， 开始时间 包含在返回集合中 按步长递增的时间点<=结束时间
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param step
	 *            步长
	 * @param stepType
	 *            步长类型 Y：年，M：月，D：日，H：时，MI：分
	 * 
	 * @return 日期集合
	 */
	public static Date[] getStepDates(final Date startDate, final Date endDate,
			int step, String stepType) {
		if (null == startDate) {
			return null;
		}
		List<Date> dayList = new ArrayList<Date>();

		int fieldType = -1;
		int field = 0;
		if ("Y".equalsIgnoreCase(stepType)) {
			field = Calendar.YEAR;
			fieldType = 1;
		} else if ("M".equalsIgnoreCase(stepType)) {
			field = Calendar.MONTH;
			fieldType = 2;
		} else if ("D".equalsIgnoreCase(stepType)) {
			field = Calendar.DATE;
			fieldType = 3;
		} else if ("H".equalsIgnoreCase(stepType)) {
			field = Calendar.HOUR_OF_DAY;
			fieldType = 4;
		} else if ("MI".equalsIgnoreCase(stepType)) {
			field = Calendar.MINUTE;
			fieldType = 5;
		}
		if (fieldType < 1) {
			return null;
		}

		if (null != startDate && null != endDate) {

			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(startDate);
			if (fieldType < 2) {
				gregoriancalendar.set(Calendar.MONTH,
						gregoriancalendar.getActualMinimum(Calendar.MONTH));
			}
			if (fieldType < 3) {
				gregoriancalendar.set(Calendar.DATE,
						gregoriancalendar.getActualMinimum(Calendar.DATE));
			}
			if (fieldType < 4) {
				gregoriancalendar.set(Calendar.HOUR_OF_DAY, gregoriancalendar
						.getActualMinimum(Calendar.HOUR_OF_DAY));
			}
			if (fieldType < 5) {
				gregoriancalendar.set(Calendar.MINUTE,
						gregoriancalendar.getActualMinimum(Calendar.MINUTE));
			}
			gregoriancalendar.set(Calendar.SECOND,
					gregoriancalendar.getActualMinimum(Calendar.SECOND));
			gregoriancalendar.set(Calendar.MILLISECOND,
					gregoriancalendar.getActualMinimum(Calendar.MILLISECOND));

			Date sDate = gregoriancalendar.getTime();

			GregorianCalendar gregoriancalendar2 = new GregorianCalendar();
			gregoriancalendar2.setTime(endDate);

			if (fieldType < 2) {
				gregoriancalendar2.set(Calendar.MONTH,
						gregoriancalendar.getActualMinimum(Calendar.MONTH));
			}
			if (fieldType < 3) {
				gregoriancalendar2.set(Calendar.DATE,
						gregoriancalendar.getActualMinimum(Calendar.DATE));
			}
			if (fieldType < 4) {
				gregoriancalendar2.set(Calendar.HOUR_OF_DAY, gregoriancalendar
						.getActualMinimum(Calendar.HOUR_OF_DAY));
			}
			if (fieldType < 5) {
				gregoriancalendar2.set(Calendar.MINUTE,
						gregoriancalendar.getActualMinimum(Calendar.MINUTE));
			}

			gregoriancalendar2.set(Calendar.SECOND,
					gregoriancalendar.getActualMinimum(Calendar.SECOND));
			gregoriancalendar2.set(Calendar.MILLISECOND,
					gregoriancalendar.getActualMinimum(Calendar.MILLISECOND));

			Date eDate = gregoriancalendar2.getTime();

			do {
				dayList.add(sDate);
				gregoriancalendar.add(field, step);
				sDate = gregoriancalendar.getTime();
			} while (sDate.getTime() <= eDate.getTime());

		}
		Date[] dayArray = new Date[dayList.size()];
		dayList.toArray(dayArray);
		return dayArray;
	}

	public static Long getDaysBetween(final Date startDate, final Date endDate) {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(endDate);
		toCalendar.set(Calendar.HOUR_OF_DAY, 0);
		toCalendar.set(Calendar.MINUTE, 0);
		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);

		return (toCalendar.getTime().getTime() - fromCalendar.getTime()
				.getTime()) / (1000 * 60 * 60 * 24);
	}

	public static boolean isTheSameDay(Date d1, Date d2) {
		if (null != d1 && null != d2) {
			GregorianCalendar gregoriancalendar1 = new GregorianCalendar();
			GregorianCalendar gregoriancalendar2 = new GregorianCalendar();
			gregoriancalendar1.setTime(d1);
			gregoriancalendar2.setTime(d2);
			return (gregoriancalendar1.get(Calendar.YEAR) == gregoriancalendar2
					.get(Calendar.YEAR))
					&& (gregoriancalendar1.get(Calendar.MONTH) == gregoriancalendar2
							.get(Calendar.MONTH))
					&& (gregoriancalendar1.get(Calendar.DAY_OF_MONTH) == gregoriancalendar2
							.get(Calendar.DAY_OF_MONTH));
		}

		return false;

	}

	public static Date getCombineDateTime(Date date, Date time) {
		Date combinedDT = null;
		Calendar combinecal = Calendar.getInstance();
		if (date == null && time == null)
			return combinedDT;
		if (date != null && time == null) {
			combinecal.setTime(date);
			combinedDT = combinecal.getTime();
		} else if (date == null && time != null) {
			combinecal.setTime(time);
			combinedDT = combinecal.getTime();
		} else {
			Calendar datecal = Calendar.getInstance();
			Calendar timecal = Calendar.getInstance();
			datecal.setTime(date);
			timecal.setTime(time);
			combinecal.set(datecal.get(1), datecal.get(2), datecal.get(5),
					timecal.get(11), timecal.get(12), timecal.get(13));
			combinecal.set(14, 0);
			combinedDT = combinecal.getTime();
		}
		return combinedDT;
	}

	/**
	 * 格式化XML文档
	 * 
	 * @param document
	 *            xml文档
	 * @param charset
	 *            字符串的编码
	 * @return 格式化后XML字符串
	 */
	public static String formatXML(Document document, String charset) {
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setSuppressDeclaration(false);
		StringWriter sw = new StringWriter();
		XMLWriter xw = new XMLWriter(sw, format);
		try {
			xw.write(document);
			xw.flush();
		} catch (IOException e) {

		} finally {
			try {
				if (null != xw) {
					xw.close();
				}
			} catch (IOException e) {
			}
		}
		return sw.toString();
	}

	public static Date stringToDate(String s) {
		return stringToDate(s, "yyyy-MM-dd");
	}

	public static Date stringToDateTime(String s) {
		return stringToDate(s, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date stringToDate(String strDate, String strFormat) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(strFormat);
		dateFormatter.setLenient(false);
		try {
			return dateFormatter.parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}

	public static String dateToString(Date d) {
		return dateToString(d, "yyyy-MM-dd");
	}

	public static String dateToString(Date d, String strFormat) {
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(d);
	}

	public static Date getDateOnly(Date date) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.set(11, 0);
		g.set(12, 0);
		g.set(13, 0);
		g.set(14, 0);
		return g.getTime();
	}

	/**
	 * 获取去年同一日期时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateOfLastYear(Date date) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.YEAR, -1);
		return g.getTime();
	}

	/**
	 * 获得上个月
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateOfLastMonth(Date date) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.MONTH, -1);
		return g.getTime();
	}

	/**
	 * 获得下一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateOfNexDay(Date date) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.DATE, 1);
		return g.getTime();
	}

	/**
	 * 获取从指定日期0点0分0秒0毫秒指定分钟步长的时间点，包含0点0分0秒0毫秒
	 * 
	 * @param startDate
	 *            开始日期，如果为null则以当前时间为准
	 * 
	 * @param minuteStep
	 *            以分钟为单位的步长，需为正整数
	 * 
	 * 
	 * @return 按步长的时间点
	 */

	public static Date[] getDatePonits(final Date startDate,
			final int minuteStep) {
		return getDatePonits(startDate, minuteStep, true);
	}

	/**
	 * 获取从指定日期0点0分0秒0毫秒指定分钟步长的时间点，不考虑秒
	 * 
	 * @param startDate
	 *            开始日期，如果为null则以当前时间为准
	 * 
	 * @param minuteStep
	 *            以分钟为单位的步长，需为正整数
	 * 
	 * @param includeZero
	 *            是否包含0点0分0秒0毫秒
	 * 
	 * @return 按步长的时间点
	 */
	public static Date[] getDatePonits(final Date startDate,
			final int minuteStep, boolean includeZero) {
		List<Date> dateList = new ArrayList<Date>();
		if (minuteStep > 0) {
			Date startTime = startDate;
			if (null == startTime) {
				startTime = new Date();
			}

			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(startTime);
			gregoriancalendar.set(Calendar.HOUR_OF_DAY, 0);
			gregoriancalendar.set(Calendar.MINUTE, 0);
			gregoriancalendar.set(Calendar.SECOND, 0);
			gregoriancalendar.set(Calendar.MILLISECOND, 0);
			// 第二天的0点0分0秒0毫秒
			gregoriancalendar.add(Calendar.DATE, 1);
			long time = gregoriancalendar.getTimeInMillis();
			// 恢复为startDate
			gregoriancalendar.add(Calendar.DATE, -1);
			Date newDate = gregoriancalendar.getTime();

			// 包含0点0分0秒0毫秒
			if (includeZero) {
				dateList.add(newDate);
			}
			// 增长分钟步长

			gregoriancalendar.add(Calendar.MINUTE, minuteStep);
			while (gregoriancalendar.getTimeInMillis() < time) {
				dateList.add(gregoriancalendar.getTime());
				gregoriancalendar.add(Calendar.MINUTE, minuteStep);
			}
		}
		Date[] dateArray = new Date[dateList.size()];
		dateList.toArray(dateArray);
		return dateArray;
	}

	public static Date getBeginOfDate(final Date date) {
		if (null == date) {
			return null;
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMinimum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMinimum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMinimum(Calendar.MILLISECOND));
		return gregorianCalendar.getTime();
	}

	public static Date getEndOfDate(final Date date) {
		if (null == date) {
			return null;
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMaximum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMaximum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMaximum(Calendar.MILLISECOND));
		return gregorianCalendar.getTime();

	}

	public static Date[] getBeginAndEndOfDate(final Date date) {
		if (null == date) {
			return null;
		}
		Date[] dates = new Date[2];
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMinimum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMinimum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMinimum(Calendar.MILLISECOND));

		dates[0] = gregorianCalendar.getTime();
		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMaximum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMaximum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMaximum(Calendar.MILLISECOND));
		dates[1] = gregorianCalendar.getTime();
		return dates;
	}

	public static Date getLastYear(final Date date) {
		if (null == date) {
			return null;
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.add(Calendar.YEAR, -1);
		return gregorianCalendar.getTime();
	}

	public static Date getLastMonth(final Date date) {
		if (null == date) {
			return null;
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.add(Calendar.MONTH, -1);
		return gregorianCalendar.getTime();
	}

	public static Date nextMonth(final Date date) {
		if (null == date) {
			return null;
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.add(Calendar.MONTH, 1);
		return gregorianCalendar.getTime();
	}

	public static Date lastDay(Date date) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.DATE, -1);
		return g.getTime();
	}

	public static Date lastDay(Date date, int count) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.DATE, -1 * count);
		return g.getTime();
	}

	public static Date toLastDay(Date date, int count) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.DATE, count);
		return g.getTime();
	}

	public static Date nextDay(Date date) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(date);
		g.add(Calendar.DATE, 1);
		return g.getTime();
	}

	public static Date getBeginOfMonth(final Date date) {
		if (null == date) {
			return null;
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH,
				gregorianCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMinimum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMinimum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMinimum(Calendar.MILLISECOND));
		return gregorianCalendar.getTime();
	}

	public static Date getEndOfMonth(final Date date) {
		if (null == date) {
			return null;
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH,
				gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMaximum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMaximum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMaximum(Calendar.MILLISECOND));
		return gregorianCalendar.getTime();
	}

	public static Date getBeginOfYear(final Date date) {
		if (null == date) {
			return null;
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.MONTH,
				gregorianCalendar.getActualMinimum(Calendar.MONTH));
		gregorianCalendar.set(Calendar.DAY_OF_MONTH,
				gregorianCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMinimum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMinimum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMinimum(Calendar.MILLISECOND));
		return gregorianCalendar.getTime();
	}

	public static Date getEndOfYear(final Date date) {
		if (null == date) {
			return null;
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.MONTH,
				gregorianCalendar.getActualMaximum(Calendar.MONTH));
		gregorianCalendar.set(Calendar.DAY_OF_MONTH,
				gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		gregorianCalendar.set(Calendar.HOUR_OF_DAY,
				gregorianCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		gregorianCalendar.set(Calendar.MINUTE,
				gregorianCalendar.getActualMaximum(Calendar.MINUTE));
		gregorianCalendar.set(Calendar.SECOND,
				gregorianCalendar.getActualMaximum(Calendar.SECOND));
		gregorianCalendar.set(Calendar.MILLISECOND,
				gregorianCalendar.getActualMaximum(Calendar.MILLISECOND));
		return gregorianCalendar.getTime();
	}

	// 获取自然月份，从1开始
	public static int getMonth(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);

		return gregorianCalendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取月份的字符串
	 * 
	 * @param date
	 * @return 长度为2的字串，1至9月份补0
	 */
	public static String getMonthString(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);

		int month = gregorianCalendar.get(Calendar.MONTH) + 1;
		return String.format("%02d", month);
	}

	public static int getYear(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);

		return gregorianCalendar.get(Calendar.YEAR);
	}

	public static String getYearString(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);

		int year = gregorianCalendar.get(Calendar.YEAR);

		return String.format("%s", year);
	}

	public static int getDay(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);

		return gregorianCalendar.get(Calendar.DATE);
	}

	public static String getDayString(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);

		int day = gregorianCalendar.get(Calendar.DATE);
		return String.format("%02d", day);
	}

	/**
	 * 判断两个日期是否为同一年月
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isTheSameMonth(Date date1, Date date2) {
		if (null == date1 || null == date2) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date1);
		int year1 = gregorianCalendar.get(Calendar.YEAR);
		int month1 = gregorianCalendar.get(Calendar.MONTH);
		gregorianCalendar.setTime(date2);
		int year2 = gregorianCalendar.get(Calendar.YEAR);
		int month2 = gregorianCalendar.get(Calendar.MONTH);

		return year1 == year2 && month1 == month2;
	}

	/**
	 * 判断两个日期是否为同一年
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isTheSameYear(Date date1, Date date2) {
		if (null == date1 || null == date2) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date1);
		int year1 = gregorianCalendar.get(Calendar.YEAR);

		gregorianCalendar.setTime(date2);
		int year2 = gregorianCalendar.get(Calendar.YEAR);

		return year1 == year2;
	}

	/**
	 * 
	 * 获取日期所在月的总天数
	 * 
	 * @param date
	 *            日期
	 * @return 日期所在月的总天数
	 */
	public static int dayCountOfMonth(Date date) {
		if (null == date) {
			throw new IllegalArgumentException("date 不能为null");
		}

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		int dayCount = gregorianCalendar
				.getActualMaximum(Calendar.DAY_OF_MONTH);
		return dayCount;
	}

	public static String formatDouble(BigDecimal bigDecimal, int scale) {
		return formatDouble(bigDecimal, scale, BigDecimal.ROUND_HALF_UP, true);
	}

	public static String formatDouble(BigDecimal bigDecimal, int scale,
			int roundingMode, boolean subZeroAndDot) {
		if (null == bigDecimal) {
			return "";
		}

		if (scale < 0) {
			throw new IllegalArgumentException("精度为正整数或0");
		}

		BigDecimal one = new BigDecimal("1");
		BigDecimal result = bigDecimal.divide(one, scale, roundingMode);
		if (subZeroAndDot) {
			return subZeroAndDot(result.toString());
		} else {
			return subZeroAndDot(result.toString());
		}

	}

	public static String formatDouble(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"精度为正整数或0");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");
		BigDecimal result = b.divide(one, scale, BigDecimal.ROUND_HALF_UP);

		return result.toString();

	}

	public static String formatDouble(double v, int scale, int roundingMode,
			boolean subZeroAndDot) {

		if (scale < 0) {
			throw new IllegalArgumentException("精度为正整数或0");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");
		BigDecimal result = b.divide(one, scale, roundingMode);

		if (subZeroAndDot) {
			return subZeroAndDot(result.toString());
		} else {
			return subZeroAndDot(result.toString());
		}

	}

	/**
	 * 使用java正则表达式去掉多余的.与0
	 * 
	 * @param s
	 * @return
	 */
	public static String subZeroAndDot(String s) {
		if (s.indexOf(".") > 0) {
			s = s.replaceAll("0+?$", "");// 去掉多余的0
			s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
		}
		return s;
	}

	/**
	 * 处理年份参数，为null、空字符串或转化失败则返回当前年份。
	 * 
	 * @param s
	 *            年份字符串
	 * 
	 * @return 转化后的年份
	 */
	public static int convertYearString(String yearString) {
		int year = -1;
		if (null != yearString && !"".equals(yearString)) {
			try {
				year = Integer.parseInt(yearString);
			} catch (NumberFormatException e) {
			}
		}
		if (year == -1) {
			year = CommonUtil.getYear(new Date());
		}
		return year;
	}

	/**
	 * 处理月份参数，为null、空字符串或转化失败则返回当前月份。
	 * 
	 * @param s
	 *            月份字符串
	 * 
	 * @return 转化后的月份，从1开始
	 */
	public static int convertMonthString(String monthString) {
		int month = -1;
		if (null != monthString && !"".equals(monthString)) {
			try {
				month = Integer.parseInt(monthString);
				if (month < 1 || month > 12) {
					month = -1;
				}
			} catch (NumberFormatException e) {

			}
		}
		if (month == -1) {
			month = CommonUtil.getMonth(new Date());
		}
		return month;
	}

	public static Long getMinsBetween(final Date startDate, final Date endDate) {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);

		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(endDate);

		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);

		return (toCalendar.getTime().getTime() - fromCalendar.getTime()
				.getTime()) / (1000 * 60);
	}

	/**
	 * 计算日期按指定分钟间隔
	 * 
	 * @param date
	 * @param minuteStep
	 * @return
	 */
	public static int getPosOfDate(Date date, long minuteStep) {
		int pos = -1;
		if (null != date) {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			gregorianCalendar.set(Calendar.HOUR_OF_DAY,
					gregorianCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
			gregorianCalendar.set(Calendar.MINUTE,
					gregorianCalendar.getActualMinimum(Calendar.MINUTE));
			gregorianCalendar.set(Calendar.SECOND,
					gregorianCalendar.getActualMinimum(Calendar.SECOND));
			gregorianCalendar.set(Calendar.MILLISECOND,
					gregorianCalendar.getActualMinimum(Calendar.MILLISECOND));

			pos = (int) ((date.getTime() - gregorianCalendar.getTime()
					.getTime()) / (1000 * 60 * minuteStep));
		}
		return pos;

	}

	/**
	 * 计算日期按指定分钟间隔
	 * 
	 * @param date
	 * @param minuteStep
	 * @return
	 */
	public static int getPosOfDateForSecond(Date date, long secondStep) {
		int pos = -1;
		if (null != date) {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			gregorianCalendar.set(Calendar.HOUR_OF_DAY,
					gregorianCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
			gregorianCalendar.set(Calendar.MINUTE,
					gregorianCalendar.getActualMinimum(Calendar.MINUTE));
			gregorianCalendar.set(Calendar.SECOND,
					gregorianCalendar.getActualMinimum(Calendar.SECOND));
			gregorianCalendar.set(Calendar.MILLISECOND,
					gregorianCalendar.getActualMinimum(Calendar.MILLISECOND));

			pos = (int) ((date.getTime() - gregorianCalendar.getTime()
					.getTime()) / (1000 * secondStep));
		}
		return pos;
	}

	/**
	 * 
	 * 转化bigDecimal为字符串，并设置保留小数位数，根据需要去除字符串末尾的小数点和0
	 * 
	 * @param value
	 *            待转化值
	 * 
	 * @param scale
	 *            保留小数位数
	 * 
	 * @param subZeroAndDot
	 *            是否去除字符串末尾的小数点和0 true-去除，false-保留
	 * 
	 * @return 转化后字符串 ，转化值为null则返回空字符串
	 */
	public static String bigDecimalToString(final BigDecimal value, int scale,
			boolean subZeroAndDot) {
		String valueString = "";
		if (null != value) {
			double doubleValue = Arith.round(value, scale);
			valueString = String.valueOf(doubleValue);
			if (subZeroAndDot) {
				valueString = subZeroAndDot(valueString);
			}
		}

		return valueString;

	}

	/**
	 * 转化bigDecimal为字符串，并设置保留小数位数
	 * 
	 * @param value
	 *            待转化值
	 * @param scale
	 *            保留小数位数
	 * @return 转化后字符串 ，转化值为null则返回空字符串
	 */
	public static String bigDecimalToString(final BigDecimal value, int scale) {
		return bigDecimalToString(value, scale, false);
	}

	/**
	 * 
	 * 从参数数据中获取日期参数，args.length>=1 args[0] 开始日期，args[1] 结束日期，
	 * 
	 * @param args
	 *            字符串参数
	 * @return 返回开始日期和结束日期之间的日期
	 */
	public static Date[] processDateArgs(String[] args) {

		if (null == args || args.length < 1) {
			return null;
		}

		int argsCount = null != args ? args.length : 0;
		int expectArgsCount = 2;
		String[] expectArgs = new String[expectArgsCount];
		if (argsCount > 0) {
			for (int i = 0; i < argsCount && i < expectArgsCount; i++) {
				expectArgs[i] = args[i];
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		if (null != expectArgs[0]) {
			try {
				startDate = sdf.parse(expectArgs[0]);
			} catch (ParseException e) {

			}
		}
		if (null != expectArgs[1]) {
			try {
				endDate = sdf.parse(expectArgs[1]);
			} catch (ParseException e) {

			}
		}
		Date[] dates = null;
		if (null != startDate && null != endDate) {
			if (endDate.before(startDate)) {
				Date tempDate = endDate;
				endDate = startDate;
				startDate = tempDate;
			}
			dates = CommonUtil.getStepDates(startDate, endDate, 1, "D");
		} else {

			if (null != startDate) {
				dates = new Date[] { startDate };
			} else if (null != endDate) {
				dates = new Date[] { endDate };
			}
		}

		return dates;
	}

	/**
	 * 
	 * 将多个点连接起来，如果多个点相邻，则合并，开始索引为第一个点，结束索引为最后一个点，如果该点没有 相邻的点，则开始索引为该点，结束索引也为该点
	 * 
	 * @param points
	 *            原始点
	 * 
	 * @return 多个开始索引与结束索引组成的数据
	 */
	public static int[][] linkPoints(int[] points) {
		if (null == points || points.length < 1) {
			return null;
		}
		Arrays.sort(points);

		List<int[]> periodList = new ArrayList<int[]>();
		int startPoint = points[0];
		int endPoint = points[0];// 和下一个点比较,确定下一个点是否加入上一段

		// 从第二个点开始遍历，形成开始点和结束点的集合
		for (int i = 1, count = points.length; i < count; i++) {
			int curPoint = points[i];
			// 当前点和上一点相邻，则更新结束点
			if ((curPoint - endPoint) == 1) {
				endPoint = curPoint;
			} else if ((curPoint - endPoint) > 1) {
				// 和上一个点不相邻，则将上一开始点和上一结束点写入集合
				int[] startEndArray = new int[2];
				startEndArray[0] = startPoint;
				startEndArray[1] = endPoint;
				periodList.add(startEndArray);

				startPoint = curPoint;
				endPoint = curPoint;
			}
		}
		// 当数据遍历完后，最后一个点区间未加入，将最后一个开始点和将最后一个结束点写入集合
		int[] startEndArray = new int[2];
		startEndArray[0] = startPoint;
		startEndArray[1] = endPoint;
		periodList.add(startEndArray);

		int[][] periodArray = new int[periodList.size()][];
		for (int i = 0, count = periodList.size(); i < count; i++) {
			int[] period = periodList.get(i);
			periodArray[i] = period;
		}

		return periodArray;

	}

	public static boolean isWindows() {
		boolean result = false;
		if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 获取开始日期和结束日期之间按步长分割的日期集合
	 * 
	 * @param startDate
	 *            开始时间 包含在返回集合中
	 * @param endDate
	 *            结束时间 不包含在返回集合中
	 * @param step
	 *            步长
	 * @param stepType
	 *            步长类型 1：年，2：月，3：日，4：时，5：分
	 * 
	 * @return 日期集合
	 */
	public static Date[] getStepDates(final Date startDate, final Date endDate,
			int step, int stepType) {
		if (null == startDate) {
			return null;
		}
		List<Date> dayList = new ArrayList<Date>();
		if (stepType < 1 || stepType > 5) {
			throw new IllegalArgumentException("stepType 参数范围为1-5，代表年、月、日、时、分");
		}
		int field = 0;
		if (1 == stepType) {
			field = Calendar.YEAR;
		} else if (2 == stepType) {
			field = Calendar.MONTH;
		} else if (3 == stepType) {
			field = Calendar.DATE;
		} else if (4 == stepType) {
			field = Calendar.HOUR_OF_DAY;
		} else if (5 == stepType) {
			field = Calendar.MINUTE;
		}

		if (null != startDate && null != endDate) {

			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(startDate);
			if (stepType < 2) {
				gregoriancalendar.set(Calendar.MONTH,
						gregoriancalendar.getActualMinimum(Calendar.MONTH));
			}
			if (stepType < 3) {
				gregoriancalendar.set(Calendar.DATE,
						gregoriancalendar.getActualMinimum(Calendar.DATE));
			}
			if (stepType < 4) {
				gregoriancalendar.set(Calendar.HOUR_OF_DAY, gregoriancalendar
						.getActualMinimum(Calendar.HOUR_OF_DAY));
			}
			if (stepType < 5) {
				gregoriancalendar.set(Calendar.MINUTE,
						gregoriancalendar.getActualMinimum(Calendar.MINUTE));
			}
			gregoriancalendar.set(Calendar.SECOND,
					gregoriancalendar.getActualMinimum(Calendar.SECOND));
			gregoriancalendar.set(Calendar.MILLISECOND,
					gregoriancalendar.getActualMinimum(Calendar.MILLISECOND));

			Date sDate = gregoriancalendar.getTime();

			GregorianCalendar gregoriancalendar2 = new GregorianCalendar();
			gregoriancalendar2.setTime(endDate);

			if (stepType < 2) {
				gregoriancalendar2.set(Calendar.MONTH,
						gregoriancalendar.getActualMinimum(Calendar.MONTH));
			}
			if (stepType < 3) {
				gregoriancalendar2.set(Calendar.DATE,
						gregoriancalendar.getActualMinimum(Calendar.DATE));
			}
			if (stepType < 4) {
				gregoriancalendar2.set(Calendar.HOUR_OF_DAY, gregoriancalendar
						.getActualMinimum(Calendar.HOUR_OF_DAY));
			}
			if (stepType < 5) {
				gregoriancalendar2.set(Calendar.MINUTE,
						gregoriancalendar.getActualMinimum(Calendar.MINUTE));
			}

			gregoriancalendar2.set(Calendar.SECOND,
					gregoriancalendar.getActualMinimum(Calendar.SECOND));
			gregoriancalendar2.set(Calendar.MILLISECOND,
					gregoriancalendar.getActualMinimum(Calendar.MILLISECOND));

			Date eDate = gregoriancalendar2.getTime();

			do {
				dayList.add(sDate);
				gregoriancalendar.add(field, step);
				sDate = gregoriancalendar.getTime();
			} while (sDate.getTime() < eDate.getTime());

		}
		Date[] dayArray = new Date[dayList.size()];
		dayList.toArray(dayArray);
		return dayArray;
	}

	// 获取输入日期所在周
	public static int getWeekNumber(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		calendar.setTime(date);
		// calendar.setMinimalDaysInFirstWeek(7);
		return calendar.get(Calendar.WEEK_OF_YEAR);

	}

	// 获取当前周 yyyy-WW
	public static String getRqWithWeek(Date date) {
		String rq = "";
		int year = getYear(date);
		int month = getMonth(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		calendar.setTime(date);
		// calendar.setMinimalDaysInFirstWeek(7);
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		if (week == 1 && month == 12) {
			year++;
		}
		rq = year + "-" + week;
		return rq;
	}

	public String p(Object o) {
		return o == null ? "对象为空！" : (o.toString());
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 
	 * @Title: fromatDateExpression
	 * @author:jiangcy
	 * @Description: 格式化时间参数
	 * @param expression
	 * @return
	 * @return: String
	 * @throws
	 */
	public static String fromatDateExpression(String expression) {
		String res = "";
		int i = expression.indexOf("%");
		if (i == -1) {
			return "";
		} else {
			try {
				String num = expression.substring(0, i);
				String type = expression.substring(i + 1);
				int n = Integer.valueOf(num);
				Date now = toLastDay(getCurrentDate(), n);
				if ("d".equalsIgnoreCase(type)) {
					res = getDayString(now);
				} else if ("y".equalsIgnoreCase(type)) {
					res = getYearString(now);
				} else if ("M".equals(type)) {
					res = getMonthString(now);
				} else if ("yyyyMMdd".equals(type)) {
					res = formatDatePath(toLastDay(getCurrentDate(), n));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static boolean isMatch(String str, String regEx){
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    return matcher.matches();
	}

	//非负整数
	public static boolean isMatch1(String str){
		String regEx = "\\d+";
		return isMatch(str,regEx);
	}
	
	
	//非负整数
		public static boolean isMatchIP(String str){
			String regEx = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"; 
			return isMatch(str,regEx);
		}
}

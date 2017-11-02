package com.cars.iivmshome.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date time related utility methods.
 * @author zy
 * @version 0.1
 */
public class DatetimeUtil {

	//格式化类型：年月日（yyyyMMdd）
	public static final String yyyyMMdd = "yyyyMMdd";
	
	//格式化类型：年月日时分秒（yyyy-MM-dd HH:mm:ss）
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	
	//格式化类型：年月日时分秒（yyyyMMddHHmmss）
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	
	/**
	 * Compute specified {@link Date} using {@link Calendar} class. For example:<br>
	 * if howManyDays=-2, date="2009-06-04 18:21:46", 
	 * then return value is "2009-06-02 18:21:46".
	 * @param howManyDays if howManyDays<0 then Math.abs(howManyDays) days ago.
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date getDatetime(int howManyDays, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, howManyDays);
		Date beforeDate = calendar.getTime();
		beforeDate.setHours(date.getHours());
		beforeDate.setMinutes(date.getMinutes());
		beforeDate.setSeconds(date.getSeconds());
		return beforeDate;
	}
	
	/**
	 * Compute specified {@link Date} using {@link Calendar} class. For example:<br>
	 * if howManyDays=-2, current date time is "2012-06-04 18:21:46", 
	 * then return value is "2012-06-02 18:21:46".
	 * @param howManyDays if howManyDays<0 then Math.abs(howManyDays) days ago.
	 * @return
	 */
	public static Date getDatetime(int howManyDays) {
		return getDatetime(howManyDays, new Date());
	}
	
	/**
	 * Compute specified {@link Date} according to date string and date format.<br>
	 * For example:<br>
	 * if dateString="2012/06/04 12:54:31", format='yyyy/MM/dd HH:mm:ss',
	 * then return the format of {@link Date} representation.
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Date getDatetime(String dateString, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Compute String format of {@link Date} according to using {@link Calendar} class
	 * and a given date time format.
	 * @param howManyDays
	 * @param date
	 * @param format
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String formatDatetime(int howManyDays, Date date, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, howManyDays);
		Date beforeDate = calendar.getTime();
		beforeDate.setHours(date.getHours());
		beforeDate.setMinutes(date.getMinutes());
		beforeDate.setSeconds(date.getSeconds());
		return formatDateTime(beforeDate, format);
	}
	
	/**
	 * Compute String format of {@link Date}.
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDateTime(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		String dateString = df.format(date);
		return dateString;
	}
	
	/**
	 * 获取格式化日期字符串
	 * */
	public static String getFormatDate(Date date, String type) {
		String ret = null;
		if (null == date) {
			return null;
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
			ret = simpleDateFormat.format(date);
			simpleDateFormat = null;
		}
		return ret;
	}
	
	/**
	 * 字符串转换日期
	 * */
	public static Date toDate(String dateStr, String type){
		SimpleDateFormat format = new SimpleDateFormat(type);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将String格式日期转为Date
	 * @param strDate
	 * @return Date
	 */
	public static Date strToDateLong(String strDate){
		Date date = null;
		if(strDate == null || strDate.length()==0){
			return date;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将String格式日期转为Date
	 * @param timeFormat
	 * @return Date
	 */
	public static Date strToDate(String strDate, String timeFormat){
		Date date = null;
		if(strDate == null || strDate.length()==0){
			return date;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 得到当前时间      type 可传入例如yyyy-MM-dd
	 * @return String
	 */
	public static String getCurrentDate(String type){
		return getFormatDate(new Date(), type);
	}
	
	/**
	 * 得到当前时间 年月日时分称 （yyyyMMddHHmmss）
	 * @return String
	 */
	public static String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss);
		return sdf.format(date);
	}
	
	// 获得当天0点时间
	public static int getTimesMorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	// 获得当天24点时间
	public static int getTimesNight() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	} 
	
	public static void main(String[] args) {
//		System.out.println(strToDateLong("2014-1-20 23:23:23"));
		System.out.println(strToDate("2014-08-11 14:38:29.0", yyyy_MM_dd_HH_mm_ss));
		System.out.println(getTimesMorning());
		System.out.println(getTimesNight());
		System.out.println("=====================");
	}
}

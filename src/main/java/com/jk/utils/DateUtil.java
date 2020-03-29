package com.jk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  * 将日期字符串转换成Date类型
 *	* 根据日期算年龄
 *	判断到未来需要的天数
 * 日期比较
 * 判断给定日期是否是当天
 * 判断当前给定的日期是否在本周之内
 * /**方法4：求未来日期离今天还剩的天数
 * 方法5：求过去日期离今天过去的天数
 */
public class DateUtil {

	/**
	 *  将日期字符串转换成Date类型
	 */
	public static Date stringToDate(String date){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = sdf.parse(date);
			return date2;
		} catch (ParseException e) {
			return null;
		}
	}
	
	
	/**
	 *  根据日期算年龄
	 */
	public static int getAge(String date){
		Date toDate = stringToDate(date);
		int age = getAge(toDate);
		return age;
	}
	public static int getAge(Date date){
		Calendar instance = Calendar.getInstance();
		int newyear = instance.get(Calendar.YEAR);
		
		Calendar instance2 = Calendar.getInstance();
		instance2.setTime(date);
		int oldyear = instance2.get(Calendar.YEAR);
		
		//过去的时间
		return newyear-oldyear;
		//未来的时间
		//return oldyear-newyear;
		
	}
	
	
	/**
	 *  判断到未来需要的天数
	 */
	public static int getFutureDays(String date){
		Date stringToDate = stringToDate(date);
		int days = getFutureDays(stringToDate);
		return days;
	}
	public static int getFutureDays(Date date){
		Date date2 = new Date();
		long newtime = date2.getTime();
		
		long xtime = date.getTime();
		
		long time = xtime-newtime;
		
		int days = (int) (time/1000/60/60/24);
		return days;
	}
	
	
	/**
	 * 判断当前给定的日期是否在本周之内
	 * @return
	 */
	public static boolean isDayInWeek(String date){
		
		Date stringToDate = stringToDate(date);
		return isDayInWeek(stringToDate);
	}
	public static boolean isDayInWeek(Date date){
		
		Calendar instance = Calendar.getInstance();
		int year1 = instance.get(Calendar.YEAR);
		int monday1 = instance.get(Calendar.MONDAY);
		int week1 = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		Calendar instance2 = Calendar.getInstance();
		instance2.setTime(date);
		int year2 = instance2.get(Calendar.YEAR);
		int monday2 = instance2.get(Calendar.MONDAY);
		int week2 = instance2.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		if(year2==year1&&monday2==monday1&&week2==week1){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		 boolean dayInWeek = isDayInWeek("2020-03-28");
		System.out.println(dayInWeek);
	}
}

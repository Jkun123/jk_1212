package com.jk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *  1.	判断源字符串是否有值，空引号也算没值
	2.	判断源字符串是否有值，空引号和空格也算没值
	3.	判断是否为手机号码
	4.	判断是否为电子邮箱
	5.	判断是否全部为字母
	6.	获取n位随机英文字符串
	7.	获取n位随机英文和数字字符串
	8.	获取n个随机中文字符串
		判断是否是小数
	 	判断是否是数字
	 	判断是否是整数
 */
public class StringUtils {
	
	/**
	 * 1.	判断源字符串是否有值，空引号也算没值
	 */
	public static boolean isEmpty1(String str){
		
		return str==null||str.length()<1;
	}
	
	
	/**
	 * 2.	判断源字符串是否有值，空引号和空格也算没值
	 */
	
	
	public static boolean isEmpty2(String str){
		
		return str==null||str.trim().length()<1;
	}
	
	
	/**
	 * 3.	判断是否为手机号码
	 */
	public static boolean isPhone(String str){
		
		String regex = "1[3|4|5|7|8|9]\\d{9}";
		return str.matches(regex );
	}
	
	
	/**
	 * 4.	判断是否为电子邮箱
	 */
	public static boolean isEmail(String str){
		
		String regex = "\\w+@\\w+\\.(com|cn)";
		return str.matches(regex );
	}
	
	
	/**
	 * 5.	判断是否全部为字母
	 */
	public static boolean isEnglish(String str){
		
		String regex = "[A-Za-z]+";
		return str.matches(regex );
	}
	
	
	/**
	 * 6.	获取n位随机英文字符串
	 */
	public static String getRandomEnglish(int x){
		//a-z : 97-122
		//A-Z : 65-90
		Random rd = new Random();
		//String str = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < x; i++) {
			int next = rd.nextInt(123);
			if(next>=65&&next<=90||next>=97&&next<=122){
				//System.out.println(next);
				char c = (char)next;
				sb.append(c);
			}else{
				--i;
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 7.	获取n位随机英文和数字字符串
	 */
	public static String getRandomEnglishAndNum(int n){
		//0-9 : 48 - 57;
		//a-z : 97-122 , A-Z : 65-90
		String str = "";
		Random rd = new Random();
		for (int i = 0; i <n; i++) {
			int next = rd.nextInt(123);
			if(next>=48&&next<=57||next>=97&&next<=122||next>=65&&next<=90){
				char c = (char)next;
				str+=c;
			}else{
				--i;
			}
		}
		return str;
	}
	
	
	
	/**
	 * 8.	获取n个随机中文字符串
	 */
	
	
	/**
	 *  判断是否是整数
	 */
	public static boolean isInt(String str){
		
		String regex = "[0-9]+";
		return  str.matches(regex );
	}
	
	/**
	 *  判断是否是小数
	 */
	public static boolean isDouble(String str){
		
		String regex = "\\d+\\.\\d+";
		return  str.matches(regex );
	}
	
	
	/**
	 *  判断是否是数字
	 */
	public static boolean isNumber(String str){
		
		if(isInt(str)){//判断是否是整数
			return true;
		}if(isDouble(str)){//判断是否是小数
			return true;
		}else{
			return false;
		}
	}
	

	/**
	 * 是不是 日期类型
	 */
	public static boolean isDate(String idate) {
		String regex = "\\d{4}-([0][1-9]|1[012])-(0[1-9]|[12][0-9]|30|31)";
		return idate.matches(regex );
	}
	
	
	public static void main(String[] args) {
		String str = "2000-01-30";
		System.out.println(isDate(str));
	}
}

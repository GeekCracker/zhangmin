package com.readbook.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 生成订单编号的工具类
 */
public class OrderCodeUtil {

	private static SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd");
	private static Integer sffset = 5;
	/**
	 * 生成订单编号
	 * @return 返回订单编号
	 */
	public static String makeOrderCode(){
		StringBuffer sb = new StringBuffer();
		sb.append("RB");
		Date date = new Date();
		sb.append(sdf.format(date));
		String time = Calendar.getInstance().getTimeInMillis()+"";
		sb.append(time.substring(time.length()-sffset, time.length()));
		return sb.toString();
	}
}
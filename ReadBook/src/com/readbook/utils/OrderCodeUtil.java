package com.readbook.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ���ɶ�����ŵĹ�����
 */
public class OrderCodeUtil {

	private static SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd");
	private static Integer sffset = 5;
	/**
	 * ���ɶ������
	 * @return ���ض������
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
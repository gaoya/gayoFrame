package org.frame.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用的时间类Utils
 * @author admin
 *
 */
public class DateUtils {
	
	public static final String ALL_FOMAT = "yyyy年MM月dd日 HH时ss分mm秒" ;
	private static SimpleDateFormat simpleDateFormat = null ;
	public static String current(String format ) {
		simpleDateFormat = new SimpleDateFormat(format) ;
		
		return simpleDateFormat.format( new Date()) ;
	}

}

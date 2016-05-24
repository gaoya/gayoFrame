package com.frame.dtime;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期和时间操作
 * @author admin
 *
 */
public class DtimeFormat {
	//完整的日期格式
	public static final String ALL_FORMAT = "yyyyMMddhhmmss" ;
	//时间戳
	public static final String TIME_STAMP = "yyyyMMddhhmmssSSS" 	;
	//年
	public static final String YEAR_FORMAT = "yyyy" ;
	//月
	public static final String MONTH_FORMAT = "MM" ;
	//日
	public static final String DAY_FORMAT = "dd" ;
	//Date 
	public static final String DATE_FORMAT = "yyyyMMdd" ;
	//time - 12小时制
	public static final String TIME12_FORMAT = "hhmmss" ;
	//time - 24小时制
	public static final String TIME24_FORMAT = "HHmmss" ;
	private SimpleDateFormat formatType = null ;
	/**
	 * 将输入的时间转换成相应的字符串类型的时间
	 * @param format
	 * @param date
	 * @return
	 */
	public String  format(String format ,Date date) {
		formatType = new SimpleDateFormat(format) ;
		return format(formatType,date) ;
	}
	/**
	 * 
	 * @param format
	 * @param date
	 * @return
	 */
	public String format (Format format ,Date date ) {
		return format.format(date);
	}
	/**
	 * 将字串类型的数据转换成相应的时间
	 * @param format
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public Date parse(String format ,String dateString) throws ParseException {
		formatType = new SimpleDateFormat(format) ;
		return parse(formatType, dateString) ;
	}
	
	public Date parse(SimpleDateFormat format ,String dateString) throws ParseException {
		return format.parse(dateString) ;
	}
	/**
	 * 将时间转换成相应的时间操作
	 * @param format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public Date parse (String format , Date date ) throws ParseException {
		return parse(format, format(format, date));	
	}
	
}

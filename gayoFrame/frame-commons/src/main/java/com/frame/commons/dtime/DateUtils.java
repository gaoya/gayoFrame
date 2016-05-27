package com.frame.commons.dtime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * @author admin
 *
 */
public class DateUtils {
	private static Integer year ;
	private static Integer month ;
	private static Integer day ;
	
	protected static Integer hour ;
	protected static Integer minute ;
	protected static Integer second ;
	
	protected static Date current = null ; 
	protected static Calendar calendar = null ;
	protected static Integer startTime = 0 ;
	protected static Integer endTime = 0 ;
	
	/**
	 * 判断current是否不存在
	 * @return
	 */
	protected static boolean isEmpty(){
		return current == null ? true : false ;
	}
	
	public static  Date current () {
		current = new Date() ;
		calendar = Calendar.getInstance() ;
		calendar.setTime(current);
		
		year = calendar.get(Calendar.YEAR) ;
		month = calendar.get(Calendar.MONTH) ;
		day  = calendar.get(Calendar.DAY_OF_MONTH) ;
		hour = calendar.get(Calendar.YEAR) ;
		minute = calendar.get(Calendar.MONTH) ;
		second  = calendar.get(Calendar.DAY_OF_MONTH) ;
		
		return new Date() ;
	}
	
	public static  String current (String format) {
		return DtimeFormat.format(format, current()) ;
	}
	
	
	/**
	 * 判断是否是闰年
	 * 	地球绕太阳转一周的实际时间是365天5时48分46秒。如果一年只有365天，那么每年就多出5个小时。
	 * 4年多出的23小时15分4秒，差不多就等于1天。于是决定每四年增加1天。
	 * 但是，它比一天24小时又少了约45分钟，如果每100年有25个闰年的话，就少了18时43分20秒，这就差不多等于1天了，这显然不合适。
	 * 可以算出，每年多出5小时48分46秒，100年就多出581小时16分40秒。而25个闰年需要25*24=600小时。
	 * 581小时16分40秒只够24个闰年（24*24=576小时），于是决定每100年只安排24个闰年（世纪年不作闰年）。
	 * 但是这样每100年又多出了5小时16分40秒（581小时16分40秒-576小时），于是又决定每400年增加一个闰年。这样就比较接近实际情况了。
	 * 根据以上的，决定闰年按照以下的计算规则：
	 * 闰年应能被4整除（如2004年是闰年，而2001年不是闰年），但不是所有被4整除的年份都是闰年。
	 * 在能被100整除的年份中，又同时能被400整除的年份才是闰年（如2000年是闰年），
	 * 能被100整除而不能被400整除的年份（如1800、1900、2100）不是闰年。这是国际公 认的规则。
	 * 只说“能被4整除的年份就是闰年”是不准确的
	 * @param year
	 * @return
	 */
	public static boolean isLeap ( int year){
		boolean flag = false ;
		
		if ( year % 4 == 0 && (year % 100 ==0 && year % 400 == 0 )) {
			flag = true ;
		}
		
		return flag ;
		
	}
	
	/**
	 * 判断今年是否是闰年
	 * @return
	 */
	public static boolean isCurrentLeap() {
		if (isEmpty()) {
			current() ;
		}
		return isLeap(year);
	}
	
	/**
	 * 从A到B 直接的所有的int类型的数据 
	 * 		包含 A 不包含  B
	 * @param start
	 * @param end
	 * @return
	 */
	protected static List<Integer> fromAtoB (int start ,int end) {
		List<Integer> ret = new ArrayList<Integer>() ;
		
		for (int i = start ; i < end ; i ++ ) {
			ret.add(i) ;
		}
		
		return ret ;
	}
	
	/**
	 * 得到一年中的所以月份
	 * @return
	 */
	public static List<Integer> months() {
		
		startTime  = 1 ;
		endTime  = 13 ;
		
		return fromAtoB(startTime, endTime) ;
	}
	/**
	 * 得到今年剩下的月份
	 * 	包括本月
	 * @return
	 */
	public static List<Integer> leaveMonthsOfCurrent () {
		if (isEmpty()) {
			current() ;
		}
		startTime = month +1 ;
		endTime = 13 ;
		
		return fromAtoB(startTime, endTime) ;
	}
	
	/**
	 * 得到这个月有多少天
	 * @return
	 */
	public static Integer daysOfMonth() {
		if (isEmpty()) {
			current() ;
		}
		Integer[] days = {31 ,isLeap(year)? 29 :28 ,31 ,30 ,31 ,30 ,31 ,31 ,30 ,31 ,30 ,31 } ;
		
		return days[month] ;
	}
	
	/**
	 * 得到今年有多少天
	 * @return
	 */
	public static Integer yearDays() {
		return isCurrentLeap() ? 366 : 365 ;
	}

	/**
	 * 得到下一年的日期
	 */
	public static Integer nextYear() {
		if (isEmpty()) {
			current();
		}
		return year + 1 ;
	}
	/**
	 * 根据一个时间得到另一个时间
	 * @return
	 */
	public static Date newDate(Integer addYears ,Integer addMonths ,Integer addDays) {
		if (isEmpty()) {
			current() ;
		}
		calendar.add(Calendar.YEAR, addYears) ;
		calendar.add(Calendar.MONTH, addMonths) ;
		calendar.add(Calendar.DAY_OF_MONTH, addDays) ;
		
		return calendar.getTime()  ;
	}
	
	public static Date newDate(Integer addYear) {
		return newDate(addYear , 0 , 0 ) ;
	}
	
	
	/**
	 * 得到今天是今年的第几天
	 * @return
	 */
	public static int dayOfYear() {
		if (isEmpty()) {
			current () ;
		}
		return calendar.get(Calendar.DAY_OF_YEAR) ;
	}
	
	/**
	 * 得到下月
	 * @return
	 */
	public static Date nextMonth() {
		return newDate(0, 1, 0) ;
	}
	
	/**
	 * 明天
	 * @return
	 */
	public static Date nextDay() {
		return newDate(0,0,1) ;
	}
	
	/**
	 * 今天是这个月的第几个星期
	 * @return
	 */
	public static Integer weekOfMonth() {
		if (isEmpty()) {
			current() ;
		}
		
		return calendar.get(Calendar.WEEK_OF_MONTH) ;
	}
	/**
	 * 今天是今年中的第几个星期
	 * @return
	 */
	public static Integer weekOfYear () {
		if (isEmpty()) {
			current() ;
		}
		return calendar.get(Calendar.WEEK_OF_YEAR) ;
	}
	
	/**
	 * 今天是星期几
	 * 	注意在西方观点中星期的顺序是
	 * 		日  一   二   三      四     五     六
	 * 		1 2 3  4  5  6  7
	 * @return
	 */
	public static Integer dayOfWeek() {
		if (isEmpty()) {
			current() ;
		}
		return calendar.get(Calendar.DAY_OF_WEEK) ;
	}
	
	/**
	 * 得到这个月最后一天
	 * @return
	 */
	public static Date lastDayOfMonth() {
		return newDate(0,0, daysOfMonth() - day) ;
		
	}

	/**
	 * 得到这个月今天之前的所有所有时间
	 * 	不包含 今天
	 * @return
	 */
	public static List<Integer> daysBeforeCurrent() {
		if (isEmpty()) {
			current() ;
		}
		startTime = 1 ;
		endTime = day ;
		return fromAtoB(startTime, endTime) ;
	}
	
	/**
	 * 得到这个月剩下的时间
	 * 	包含 今天
	 * @return
	 */
	public static List<Integer> daysAfterCurrent() {
		if (isEmpty()) {
			current() ;
		}
		startTime = day ;
		endTime = daysOfMonth() ;
		return fromAtoB(startTime, endTime) ;
	}
	

}

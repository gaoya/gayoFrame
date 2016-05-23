package com.frame.utils;

/**
 * 工具类
 * @author admin
 *
 */
public class StringUtils {
	
	/**
	 * 判断是否为空
	 * @param msg
	 * @return
	 */
	public static boolean isEmpty(String msg) {
		boolean flag = false ;
		if (msg != null &&  msg.length() != 0) {
			flag = true ;
		}
		return flag ;
	}
	
	
	/**
	 * 将null 类型的数据转换成 "" 类型的数据
	 * @param msg
	 * @return
	 */
	public static String emptyToSpace(String msg ) {
		String ret = "" ;
		if ( !isEmpty(msg)) {
			ret = msg ;
		}
		return ret ;
	}

}

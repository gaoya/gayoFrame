package org.frame.log;

import org.frame.utils.DateUtils;

public class AbstractLogger implements org.frame.log.Logger {

	protected static java.util.logging.Logger abstractLogger = null ;
	protected static String LOG_TYPE = AbstractLogger.class.getName() ;
	public static Logger getLog(Class<?> clazz) {
		AbstractLogger.abstractLogger  = java.util.logging.Logger.getLogger(clazz.getName());
		return new AbstractLogger();
	}
	
	public void info() {
		msg("", LogLevel.INFO.toString(), null);
		
	}
	public void info(String msg) {
		msg(msg, LogLevel.INFO.toString(), null);
	}

	public void warning() {
		msg("", LogLevel.WARING.toString(), null);
		
	}

	public void warning(String msg) {
		msg(msg, LogLevel.WARING.toString(), null);
		
	}

	public void debug() {
		msg("", LogLevel.DEBUG.toString(), null);
		
	}

	public void debug(String msg) {
		msg(msg, LogLevel.DEBUG.toString(), null);
		
	}

	public void error() {
		msg("", LogLevel.ERROR.toString(), null);
		
	}

	public void error(String msg) {
		msg(msg, LogLevel.ERROR.toString(), null);
		
	}

	public void error(String msg, Throwable e) {
		msg(msg, LogLevel.ERROR.toString(), e);
	}

	/**
	 * 显示信息
	 */
	public void msg(String msg ,String logLevel ,Throwable e) {
		StringBuffer sb = new StringBuffer() ;
		String exp = e == null ? "" :e.getClass().getName() ;
		sb.append(" ****************************************");
		sb.append("\n **	时间          ： " + DateUtils.current(DateUtils.ALL_FOMAT));
		sb.append("\n **	日志类型  ：" + LOG_TYPE);
		sb.append("\n **	日志等级  ：" + logLevel);
		sb.append("\n **	类              ： " + AbstractLogger.abstractLogger.getName());
		sb.append("\n **	方法          ： " + AbstractLogger.abstractLogger.getHandlers().toString());
		sb.append("\n **	描述信息  ：" + msg);
		sb.append("\n **	异常          ： " + exp);
		sb.append("\n ****************************************");
		System.out.println(sb.toString());	
	}

	
}

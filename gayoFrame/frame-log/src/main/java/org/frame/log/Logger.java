package org.frame.log;

/**
 * 	定义一个日志使用的接口文件
 * 	
 * @author admin
 *
 */
public interface  Logger {

	public void info () ;
	public void info (String msg) ;

	public void warning () ;
	public void warning(String msg) ;

	public void debug();
	public void debug(String msg) ;

	public void error() ;
	public void error(String msg) ;
	public void error(String msg ,Throwable e) ;

	/**
	 * 拼装信息
	 */
	public void msg(String msg ,String logLevel ,Throwable e) ;
}

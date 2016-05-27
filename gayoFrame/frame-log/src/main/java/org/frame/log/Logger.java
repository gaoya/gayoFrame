package org.frame.log;

/**
 * 	定义一个日志使用的接口文件
 * 	
 * @author admin
 *
 */
public abstract class  Logger {
	private static String LOG_TYPE = "";
	private Logger logger = null ;
	
	public abstract void info () ;
	public abstract void info (String msg) ;

	public abstract void warning () ;
	public abstract void warning(String msg) ;

	public abstract void debug();
	public abstract void debug(String msg) ;

	public abstract void error() ;
	public abstract void error(String msg) ;
	public abstract void error(String msg ,Throwable e) ;
	
	/**
	 * 拼装信息
	 */
	protected void msg(String msg ,String logLevel ,Throwable e) {
		StringBuffer sb = new StringBuffer() ;
		String exp = e == null ? "" :e.getClass().getName() ;
		sb.append(" ****************************************");
//		sb.append("\n **	时间          ： " + DateUtils.current(DateUtils.ALL_FOMAT));
		sb.append("\n **	日志类型  ：" + LOG_TYPE);
		sb.append("\n **	日志等级  ：" + logLevel);
		sb.append("\n **	类              ： " + logger.getClass().getName());
		sb.append("\n **	方法          ： " + logger.getClass().toString());
		sb.append("\n **	描述信息  ：" + msg);
		sb.append("\n **	异常          ： " + exp);
		sb.append("\n ****************************************");
		System.out.println(sb.toString());	
	};
	
	//直接从这个里面返回一个Logger对象
	public static Logger log(){
		JdkLogger logger = new JdkLogger() ;
		LOG_TYPE=logger.getClass().getName() ;		
		return logger ;
	}
}

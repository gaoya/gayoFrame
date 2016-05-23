package com.frame.factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.frame.log.Logger;
import org.frame.log.impl.JdkLogger;

import com.frame.db.DbAccess;

/**
 * 工厂方法，用于生产DbAccess对象
 * @author admin
 *
 */
public class DbFactory {
	private static Logger logger = JdkLogger.getLog(DbFactory.class) ;
	private static List<Connection> dbs = new ArrayList<Connection>() ;
	private static String DRIVER = "";
	private static String URL = "" ;
	private static String USERNAME = "" ;
	private static String PASSWORD = "" ;
	private static int MINSIZE = 5 ;
	private static int MAXSIZE = 10 ;
	private static long TIMEOUT = 5000 ;		//毫秒
	private static int RE = 5 ;			//重试次数
	private static Connection conn = null ;
	/**
	 * 创建dbs的对象
	 */
	public static Connection product() {
		//检查更新
		check();
		conn = dbs.get(0) ;
		dbs.remove(0) ;
		return conn;
	}
	
	private static void check() {
		//获取当前连接池的个数
				int currentSize = dbs.size() ;
				
				if (currentSize < MINSIZE) {
					for (int count = currentSize ;count<=MAXSIZE ;count ++) {
						dbs.add(new DbAccess(DRIVER, URL, URL, PASSWORD).getConn()) ;
					}
				}
				
				if(currentSize > MAXSIZE) {
					for (int count = MAXSIZE ;count <currentSize ; count ++ ) {
						conn = dbs.get(count) ;
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("移除Connection失败！",new SQLException());
						} 
						dbs.remove(count) ;
					}
					
				}
	}

	
}

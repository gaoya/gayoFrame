package com.frame.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.frame.log.JdkLogger;
import org.frame.log.Logger;

public class StatementFactory {
//	private static Logger logger  = JdkLogger.getLog(StatementFactory.class);
	private static PreparedStatement preparedStatement = null ;
	private static Connection connection = DbFactory.product();
	private static Statement statement ;
	@SuppressWarnings("finally")
	public static PreparedStatement productPrepared(String sql)  {
		try {
			preparedStatement = connection.prepareStatement(sql) ;
		} catch (SQLException e) {
			connection = DbFactory.product() ;
			if(connection == null || connection.isClosed()) {
//				logger.error("数据库连接出现问题，请稍后再试！", e);
			}
		}finally {
			return preparedStatement ;
		}
	}
	
	/**
	 * 操作
	 * @return
	 */
	public static Statement productStatement() {
		try {
			statement = connection.createStatement() ;
		} catch (SQLException e) {
//			logger.error("数据库连接出现问题，请稍后再试！", e);
		}
		return statement;
		
	}

}

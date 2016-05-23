package com.frame.db;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.frame.log.Logger;
import org.frame.log.impl.JdkLogger;

import static com.frame.utils.StringUtils.* ;
/**
 * Created by admin on 2016/5/23.
 *  创建Connection
 *
 *
 */
public class DbAccess {
	//日志信息
	private static Logger logger = JdkLogger.getLog(DbAccess.class) ;
    private static String DRIVER = "oracle.jdbc.driver.OracleDriver" ;
    private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl" ;
    private static String USERNAME = "spvtxct" ;
    private static String PASSWORD = "spvtxct" ;
    private Connection con = null ;
    public DbAccess(String driver ,String url ,String username ,String password) {
    	Class<?> clazz = null ;
    	//对各个属性进行判断操作
    	if (!isEmpty(driver)) {
    		DbAccess.DRIVER  = driver ;
    	}
    	if (!isEmpty(url)) {
    		this.URL = url ;
    	}
    	if (!isEmpty(username)) {
    		DbAccess.USERNAME = username ;
    	}
    	if (!isEmpty(password)) {
    		this.PASSWORD = password ;
    	}
    	//加载驱动
    	try {
    		if (clazz==null) {
    			clazz = Class.forName(DRIVER) ;
    		}
    	} catch (ClassNotFoundException e) {
    		logger.error("加载驱动程序有误，请检查驱动是否正确!",new java.lang.ClassNotFoundException()) ;;
    	}

    	try {
    		this.con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	} catch (SQLException e) {
    		logger.error("连接数据库失败，请检查数据库相关配置操作", new java.lang.ClassNotFoundException());
    	}
    }
    /**
     * 得到connection对象信息
     * @return
     */
    public Connection getConn(){
    	return this.con ;
    }
	public DbAccess() {
		super();
	}
   
    
    
}

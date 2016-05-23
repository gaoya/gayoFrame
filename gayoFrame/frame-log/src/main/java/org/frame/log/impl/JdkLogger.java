package org.frame.log.impl;

import org.frame.log.AbstractLogger;
import org.frame.log.Logger;
import org.frame.utils.DateUtils;

public class JdkLogger extends AbstractLogger {
	
	public static Logger getLog(Class<?> clazz) {
		abstractLogger  = java.util.logging.Logger.getLogger(clazz.getName());
		LOG_TYPE = JdkLogger.class.getName() ;
		return new JdkLogger();
	}
	
	
	public void info() {
		super.info(); 
		
	}

	public void info(String msg) {
		super.info(msg);
		
	}

	public void warning() {
		super.warning(); 
		
	}

	public void warning(String msg) {
		super.warning(msg);
		
	}

	public void debug() {
		super.debug();
		
	}

	public void debug(String msg) {
		super.debug(msg);
		
	}

	public void error() {
		super.error(); 
		
	}

	public void error(String msg) {
		super.error(msg);
		
	}

	public void error(String msg, Throwable e) {
		 super.error(msg, e);
	}

}

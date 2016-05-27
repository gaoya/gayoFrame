package org.frame.log;

public class JdkLogger extends Logger {
	
	public JdkLogger() {
		
	}
	public JdkLogger(String packageName) {
		
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
}

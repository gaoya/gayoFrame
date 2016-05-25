package com.frame.reg;
/**
 * 拆分方法
 * @author admin
 *
 */
public class Spliter {
	//传入的信息
	private String msg ;
	//规则
	@SuppressWarnings("unused")
	private String reg ;
	//从开始位置开始拆分
	@SuppressWarnings("unused")
	private int limit = 0 ;
	// 
	private static String[] ret  = null ;
	
	public static String[] split(String msg ,String reg ,int limit) {
		ret = msg.split(reg, limit) ;
		return ret ;
	}
	public static String[] split(String msg ,String reg) {
		ret = msg.split(reg) ;
		return ret ;
	}
	public String[] split(String msg) {
		this.msg = msg ;
		return this.msg.split(this.reg) ;
	}

	@SuppressWarnings("unused")
	private Spliter(){}
	public Spliter(String reg ,String msg ) {
		this.reg = reg ;
		this.msg = msg ;
	}
	
	public Spliter(String reg) {
		this.reg = reg ;
	}
	
}

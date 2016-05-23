package com.frame.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultMapper {
	private List<String> columnName = null ;
	private List<Object> columnType = null ;
	private List<String> columnTypeNames = null ;
	/**
	 * resultset的返回集合
	 * @param rs
	 * @throws SQLException 
	 */
	public void deal(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData() ;
		//得到database中的column的个数
		int count = rsmd.getColumnCount() ;
		columnName = new ArrayList<String>() ;
		columnType = new ArrayList<Object>() ;
		columnTypeNames = new ArrayList<String>() ;
		for (int i = 1 ;i <= count ;i ++) {
			columnName.add(rsmd.getColumnName(i)) ;
			columnType.add(rsmd.getColumnType(i));
			columnTypeNames.add(rsmd.getColumnTypeName(i)) ;
		}
	}
	
	/**
	 * 得到一个对象
	 * 		为一个对象赋值
	 * @return
	 */
	public Object  one(Object o) {
		
		return null ;
		
	}
	
	
}

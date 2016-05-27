package com.frame.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.frame.reflect.RefClass;
import com.frame.reflect.RefMethod;


public class ResultMapper<T> {
	private RefClass refClass = new RefClass() ;
	private RefMethod refMethod = new RefMethod() ;
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
//			System.out.println(rsmd.getCatalogName(i) +
//			 "  "	+	rsmd.getSchemaName(i)	 +
//			 "  "	+	rsmd.getTableName(i)	 +
//			 "  "	+	rsmd.getColumnClassName(i)	 +
//			 "  "	+	rsmd.getColumnLabel(i)	 +
//			 "  "	+	rsmd.getColumnName(i)	
//					);
			
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
	@SuppressWarnings("finally")
	public Object  one(String packageName ,ResultSet rs) {
		Object ret = null ;
		try {
			ret  =  dataFromResultSet(packageName ,rs).get(0) ;
		} catch (SQLException e) {
			ret = null ;
		}finally {
			return ret ;
		}
	}
	
	/**
	 * 从ResultSEt中得到Object类型的数据集合
	 * @param clazz 对象类型 例如：String.class ,StringBuffer.class
	 * @param rs  得到的rs返回
	 * @return
	 * @throws SQLException 
	 */
	public List<Object> dataFromResultSet(Class<T> clazz ,ResultSet rs) throws SQLException {
		return dataFromResultSet(clazz.getName(),rs);
	}
	
	public List<Object> dataFromResultSet(String packageName ,ResultSet rs) throws SQLException {
		deal(rs);
		List<Object> ret = new ArrayList<Object>();
//		//创建对象
		Object object = null  ;
		//若数据存在则，进行处理操作
		while (rs.next()) {
			object = refClass.createObjectFromPackageName(packageName) ;
			String colName = "" ;;
			Object colType = null ;
			Object value = null ;
			for (int i = 0 ;i <= columnName.size() ;i ++) {
				colName = columnName.get(i).toLowerCase() ;
				colType = columnType.get(i) ;
				value = rs.getObject(colName) ;
				
				refMethod.setter(object, colName,value);
				
			}
			
			ret.add(object) ;
		}
		return ret;
	}

	public List<String> getColumnName() {
		return columnName;
	}

	public List<Object> getColumnType() {
		return columnType;
	}

	public List<String> getColumnTypeNames() {
		return columnTypeNames;
	}
	
	
	
}

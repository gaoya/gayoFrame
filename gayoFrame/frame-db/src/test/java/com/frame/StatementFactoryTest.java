package com.frame;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.frame.factory.StatementFactory;

public class StatementFactoryTest {
	private PreparedStatement preparedStatement ;
	ResultSet rs = null ;
	@Test
	public void testProductPrepared() throws SQLException {
		preparedStatement = StatementFactory.productPrepared("select 1 ,2,3 from dual ") ;
		rs = preparedStatement.executeQuery() ;
		ResultSetMetaData rsmd = rs.getMetaData() ;
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(1) + "   " + rsmd.getColumnName(2));
		
	}

	@Test
	public void testProductStatement() {
//		fail("Not yet implemented");
	}

}

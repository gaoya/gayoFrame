package com.frame.mapper;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.frame.SysTitle;
import com.frame.factory.StatementFactory;

public class ResultMapperTest {
	String sql = "select title_type ,title_name from sys_title" ;
	PreparedStatement p = StatementFactory.productPrepared(sql) ;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ResultMapper<SysTitle> rsm = new ResultMapper() ;

	@Test
	public void testDeal() throws SQLException {
		
		ResultSet rs = p.executeQuery() ;
		rsm.deal(rs);
		for (Object o : rsm.getColumnName()) {
			System.out.println( o );
		}
		System.out.println("=====================");
		for (Object o : rsm.getColumnType()) {
			System.out.println( o );
		}
		System.out.println("=====================");
		for (Object o : rsm.getColumnTypeNames()) {
			System.out.println( o );
		}
		
		
	}

	@Test
	public void testOne() throws Exception {
		ResultSet rs = p.executeQuery() ;
		List<Object> list = rsm.dataFromResultSet(SysTitle.class,rs) ;
		for (Object sys : list ) {
			System.out.println(sys.toString() ) ;
		}
	}

	

	@Test
	public void testDataFromResultSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColumnName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColumnType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColumnTypeNames() {
		fail("Not yet implemented");
	}

}

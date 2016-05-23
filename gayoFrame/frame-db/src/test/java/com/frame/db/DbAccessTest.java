package com.frame.db;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DbAccessTest {
	DbAccess db = new DbAccess() ;
	List<Connection> list = new ArrayList<Connection>() ;
	@Test
	public void test() throws SQLException {
//		System.out.println(getConn);
//		System.out.println(db.getConn() ==db.getConn() ) ;
//		list.add(db.con) ;
//		list.add(db.con) ;
//		list.add(db.con ) ;
		
		Connection c  = list.get(0) ;
		c.close();
		for(Connection cc :list) {
			if ( c.isClosed()) {
				System.out.println( "is closed");
			}
			
		}
	}

}

package com.frame.reflect;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class RefClassTest {
	RefClass refClass = new RefClass() ;

	@Before
	public void testCreateObjectFromPackageName() {
		Object o =refClass.createObjectFromPackageName("java.lang.StringBuffer") ;
		if ( o instanceof StringBuffer ) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	@Test
	public void testClassNameClassOfQ() {
		String className = refClass.className(String.class) ;
		System.out.println(className);
	}

	@Test
	public void testClassName() {
		System.out.println(refClass.className());;
	}

	@Test
	public void testClassSimpleNameClassOfQ() {
		String simpleName = refClass.classSimpleName(String.class) ;
		System.out.println(simpleName);
	}

	@Test
	public void testClassSimpleName() {
		System.out.println(refClass.classSimpleName());
	}

	@Test
	public void testFieldFromClassClassOfQ() {
		Field[] field = refClass.fieldFromClass(Object.class) ;
		for (Field fi :field) {
			System.out.println(fi.getName());
		}
	}

	@Test
	public void testFieldFromClass() {
		Field[] field = refClass.fieldFromClass() ;
		for (Field fi :field) {
			System.out.println(fi.getName());
		}
	}

	@Test
	public void testDeclaredFieldsFromClassClassOfQ() {
		Field[] fields = refClass.declaredFieldsFromClass(Person.class) ;
		for (Field f :fields) {
			System.out.println(f.getName());
		}
	}

	@Test
	public void testDeclaredFieldsFromClass() {
		Field[] fields = refClass.declaredFieldsFromClass() ;
		for (Field f :fields) {
			System.out.println(f.getName());
		}
	}

	/**
	 * 得到一个类中的所有方法
	 */
	@Test
	public void testMethodsClassOfQ() {
		Method[] m = refClass.methods(Person.class) ;
		for (Method mOne : m ) {
			System.out.println(mOne.getName());
		}
	}

	@Test
	public void testMethods() {
		Method[] methods = refClass.methods() ;
		for (Method m :methods ) {
			System.out.println( m );
		}
	}

	@Test
	public void testDeclaredMethodsClassOfQ() {
		Method[] methods =refClass.methods(Person.class) ;
		for (Method m :methods ) {
			System.out.println( m );
		}
	}

	@Test
	public void testDeclaredMethods() {
		Field[] filed = refClass.declaredFieldsFromClass() ;
		for (Field f :filed ) {
			System.out.println( f );
		}
	}

}

class Person {
	private String name ;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String show() {
		return null ;
	}
}

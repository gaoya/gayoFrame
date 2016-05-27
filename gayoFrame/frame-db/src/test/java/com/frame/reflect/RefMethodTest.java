package com.frame.reflect;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RefMethodTest {
	RefMethod refMe = new RefMethod() ;
	Human human  = new Human() ;
	@Test
	public void testCreateMethodFromClassMethodName() {
		List<Object> list = new ArrayList<Object>() ;
		list .add("gaoya") ;
		String ret = (String) refMe.createMethodFromClassMethodName(Human.class, "showName",list  );
		System.out.println(ret );
	}

	@Test
	public void testCreateMethodFromObjectMethodName() {
		List<Object> list = new ArrayList<Object>() ;
		list .add("gaoya1111") ;
		String ret = (String) refMe.createMethodFromObjectMethodName(human, "showName",list  );
		System.out.println(ret );
	}

	@Test
	public void testGetterObjectString() {
		human.setAge(12);
		System.out.println(refMe.getter(human, "age") );
	}
	@Test
	public void testSetterObjectString() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		refMe.setter(human, "age" ,12);
		refMe.setter(human, "name" ,"12313");
		System.out.println(human.toString());
	}

}

class Human {
	private String name ;
	private int age ;
	
	public void show () {
		
	}
//	@SuppressWarnings("unused")
//	private String showName() {
//		return this.name ;
//	}
	
	public String showName(String name) {
		return "showName" + name ;
	}
	public Human() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
	
}

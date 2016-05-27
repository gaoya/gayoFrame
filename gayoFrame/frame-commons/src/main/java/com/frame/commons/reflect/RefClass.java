package com.frame.commons.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.frame.log.JdkLogger;
import org.frame.log.Logger;
/**
 * 通过反射机制对class 进行操作
 * @author admin
 *
 */
public class RefClass {
	private Class<?> cls = null ;
	/**
	 * 通过一个packageName创建一个对象
	 * @return
	 */
	@SuppressWarnings("finally")
	public Object createObjectFromPackageName(String packageName) {

		Object o = null;
		try {
			if (packageName!=null ) {
				o = Class.forName(packageName).newInstance();
				this.cls = o.getClass() ;
				return o ;
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return o ;
		}
	}
	/**
	 * 得到一个类的名称
	 * @return
	 */
	public String className(Class<?> clazz) {
		return clazz.getName();
	}

	public String className() {
		return this.cls.getName() ;
	}
	
	/**
	 * 得打一个类的简单名称
	 * @param clazz
	 * @return
	 */
	public String classSimpleName (Class<?> clazz) {
		return clazz.getSimpleName() ;
	}
	
	public String classSimpleName() {
		return this.cls.getSimpleName() ;
	}
	/**
	 * 得到类中的所有属性
	 * @param clazz
	 * @return
	 */
	public Field[] fieldFromClass (Class<?> clazz) {
		Field[] fields = clazz.getFields() ;
		return fields ;
	}
	public Field[] fieldFromClass () {
		return fieldFromClass(cls) ;
	}
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public Field[] declaredFieldsFromClass (Class<?> clazz) {
		return clazz.getDeclaredFields() ;
	}
	
	public Field[] declaredFieldsFromClass () {
		return declaredFieldsFromClass(cls) ;
	}
	
	/**
	 * methods
	 * @param clazz
	 * @return
	 */
	public Method[] methods(Class<?> clazz) {
		 return clazz.getMethods();
	}
	public Method[] methods() {
		 return cls.getMethods();
	}
	
	public Method[] declaredMethods (Class<?> clazz) {
		return clazz.getDeclaredMethods() ;
	}
	
	public Method[] declaredMethods () {
		return cls.getDeclaredMethods() ;
	}
	
}

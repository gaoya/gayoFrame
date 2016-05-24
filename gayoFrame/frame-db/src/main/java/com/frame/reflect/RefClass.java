package com.frame.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.frame.log.Logger;
import org.frame.log.impl.JdkLogger;
/**
 * 通过反射机制对class 进行操作
 * @author admin
 *
 */
public class RefClass {
	private Logger logger = JdkLogger.getLog(RefClass.class) ;
	private Class<?> cls = null ;
	/**
	 * 通过一个packageName创建一个对象
	 * @return
	 */
	public Object createObjectFromPackageName(String packageName) {
		try {
			if (packageName!=null ) {
				Object o = Class.forName(packageName).newInstance() ;
				this.cls = o.getClass() ;
				return o ;
			}
		} catch (InstantiationException e) {
			logger.error("创建对象失败!", e);
		} catch (IllegalAccessException e) {
			logger.error("创建对象失败!", e);
		} catch (ClassNotFoundException e) {
			logger.error("创建对象失败!", e);
		}
		return null;	
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

package com.frame.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.frame.log.Logger;
import org.frame.log.impl.JdkLogger;

/**
 * method 操作
 * @author admin
 *
 */
public class RefMethod {
	private Logger logger = JdkLogger.getLog(RefClass.class) ;
	
	/**
	 * 	根据Class创建方法
	 * @param clazz
	 * @param methodName
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@SuppressWarnings("finally")
	public Object createMethodFromClassMethodName(Class<?> clazz ,String methodName,List<Object> param) {
		Class<?>[] listType = new Class[param.size()] ;
		Object ret = null ;
		// 方法类型设置
		if (param.size() == 0) {
			listType = null ;
		} else {
			for (int i = 0 ;i < param.size() ;i ++ ) {
				listType[i] = (param.get(i)).getClass();
			}
		}
		try {
			Method method = clazz.getDeclaredMethod(methodName, listType);
			ret= method.invoke(clazz, param) ;
		} catch (IllegalAccessException e) {
			logger.error("创建对象失败！", e);
		} catch (IllegalArgumentException e) {
			logger.error("创建对象失败！", e);
		} catch (InvocationTargetException e) {
			logger.error("创建对象失败！", e);
		} catch (NoSuchMethodException e) {
			logger.error("创建对象失败！", e);
		} catch (SecurityException e) {
			logger.error("创建对象失败！", e);
		}finally {
			return ret ;
		}
	}
	/**
	 * 根据对象和方法名称创建方法
	 * @param object
	 * @param methodName
	 * @param param
	 * @return
	 */
	public Object createMethodFromObjectMethodName(Object object ,String methodName ,List<Object> param) {
		Class<? extends Object> clazz = object.getClass() ;
		return createMethodFromClassMethodName(clazz ,methodName ,param) ;
	}

	/**
	 * 得到getter 方法
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	public Object getter(Class<?> clazz ,String methodName ) {
		List<Object> param = null ;
		return createMethodFromClassMethodName(clazz ,methodName ,param);	
	}
	public Object getter (Object object ,String methodName) {
		return getter(object.getClass(), methodName) ;
	}
	
	/**
	 * setter 设置
	 * @param clazz
	 * @param methodName
	 */
	public void setter (Class<?> clazz ,String methodName) {
		List<Object> param = null ;
		createMethodFromClassMethodName(clazz, methodName, param) ;
	}
	
	public void setter (Object object ,String methodName) {
		setter(object.getClass(), methodName) ;
	}
	
}

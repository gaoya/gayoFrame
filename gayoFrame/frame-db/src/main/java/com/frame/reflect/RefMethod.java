package com.frame.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
	public Object createMethodFromClassMethodName(Class<?> clazz ,String methodName,Object[] param) {
		Class<?>[] listType = null  ;
		Object ret = null ;
		Object target = null ;
		if (param != null && param.length !=0 ) {
			listType = new Class<?>[param.length] ;
			for (int i = 0 ;i < param.length ;i ++ ) {
				listType[i] = (param[i]).getClass();
			}
		}
		try {
			target = clazz.newInstance() ;
			Method method = target.getClass().getDeclaredMethod(methodName, listType);
			ret= method.invoke(target, param) ;
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
	
	public Object createMethodFromClassMethodName(Class<?> clazz ,String methodName,List<Object> param) {
		Object[] paramO = null ;
		if (param != null) paramO = param.toArray() ;
		return createMethodFromClassMethodName(clazz ,methodName,paramO) ;
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
	@SuppressWarnings("finally")
	public Object getter (Object object ,String methodName) {
		Object ret =null;
		try {
			if (methodName != null && methodName.trim().length() !=0 ) {
				Method method = object.getClass().getDeclaredMethod("get" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1));
				ret= method.invoke(object) ;
			}
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
	 * setter 设置
	 * @param clazz
	 * @param methodName
	 * @return 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings("rawtypes")
	public void setter (Object object ,String methodName,Object param) {

		Class[] parameterTypes = new Class[1];       
		Field field;
		try {
			if (param != null && (methodName != null && methodName.trim().length() != 0)) {
				field = object.getClass().getDeclaredField(methodName);
				parameterTypes[0] = field.getType();            
				Method me = object.getClass().getMethod("set" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1), parameterTypes);  
				me.invoke(object, param) ;
			}
		} catch (IllegalAccessException e) {
			logger.error("创建对象失败！", e);
		} catch (IllegalArgumentException e) {
			logger.error("创建对象失败！", e);
		} catch (InvocationTargetException e) {
			logger.error("创建对象失败！", e);
		} catch (NoSuchFieldException e) {
			logger.error("创建对象失败！", e);
			
		} catch (SecurityException e) {
			logger.error("创建对象失败！", e);
			
		} catch (NoSuchMethodException e) {
			logger.error("创建对象失败！", e);
			
		}

	}

}

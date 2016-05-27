package com.frame.commons.file;

import java.io.File;

public class FileUtils {
	static File file = null ;
	@SuppressWarnings("unused")
	private static String fileName = "" ;
	
	/**
	 * 得到文件上层目录
	 * 		若file是文件，则可以得到上层目录
	 * 		若file不是文件，而是目录，则得到当前目录
	 * @param fileName
	 * @return
	 */
	public static String parent(String fileName) {
		file = new File(fileName) ;
		return file.getParent();
	}
	
	public static void exist() {
		
	}
}

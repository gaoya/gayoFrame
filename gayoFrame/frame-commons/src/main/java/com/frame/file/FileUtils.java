package com.frame.file;

import java.io.File;

public class FileUtils {
	static File file = null ;
	@SuppressWarnings("unused")
	private static String fileName = "" ;
	
	public static String parent(String fileName) {
		file = new File(fileName) ;
		return null;
	}
	
}

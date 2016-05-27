package com.frame.file;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUtilsTest {
	
	@Test
	public void testParent() {
		String parent = FileUtils.parent("F:\\优秀框架学习\\hibernate-release-5.1.0.Final\\lgpl.txt") ;
		System.out.println(parent);
	}

}

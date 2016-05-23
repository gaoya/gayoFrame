package com.frame.utils;

import org.junit.Test;

/**
 * Created by admin on 2016/5/23.
 */
public class ProUtilsTest {
    ProUtils proUtils = new ProUtils() ;
   
    @Test
    public void testProUtils() throws Exception {
		proUtils.load("jdbc.properties");
		proUtils.keys();
	}

}
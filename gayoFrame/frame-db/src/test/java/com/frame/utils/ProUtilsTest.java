package com.frame.utils;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by admin on 2016/5/23.
 */
public class ProUtilsTest extends TestCase {
    ProUtils proUtils = new ProUtils() ;
    public void testLoad() throws Exception {
        proUtils.load("classpath:/jdbc.properties");
        List<String> list = proUtils.keys() ;
        for (String key : list) {
            System.out.println( key);
        }
    }


}
package com.frame.commons.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.frame.log.JdkLogger;

/**
 * Properties的工具类
 */
public class ProClassPathUtils {
//	org.frame.log.Logger logger = JdkLogger.getLog(ProFileUtils.class) ;
    Properties properties ;
    /**
     * 读取properties 文件信息
     * @param path
     */
    public void load( String path) throws IOException {
//    	logger.info();
        InputStream inputStream = ProClassPathUtils.this.getClass().getResourceAsStream(path);;
        load(inputStream);
    }
    public void load (InputStream inputStream) throws IOException {
        this.properties = new Properties() ;
        this.properties.load(inputStream);
    }

    /**
     * 得到value的值
     * @param key
     * @return
     */
    public String value(String key) {
        return (String) this.properties.get( key );
    }

    /**
     * 得到properties中key的集合信息
     * @return
     */
    public List<String> keys() {
        Enumeration<?> enumerations = properties.keys() ;
        List<String> retList = new ArrayList<String>() ;
        while( enumerations.hasMoreElements()) {
            retList .add( (String) enumerations.nextElement()) ;
        }
        return  retList ;
    }
}
//</editor-fold>

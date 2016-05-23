package com.frame.db;

/**
 * Created by admin on 2016/5/23.
 *  创建Connection
 *
 *
 */
public class DbAccess {
    private static final String DRIVER = "" ;
    private static final String URL = "" ;
    private static final String USERNAME = "" ;
    private static final String PASSWORD = "" ;

    static {
        //添加驱动
        try {
            Class.forName(DRIVER) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

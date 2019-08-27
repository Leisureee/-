package com.supermarket.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


public class SessionManager {
    private static SqlSessionFactory sqlSessionFactory;
    
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatisConfiguration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
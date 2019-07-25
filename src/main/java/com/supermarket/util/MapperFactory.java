package com.supermarket.util;

import com.supermarket.service.DBOperateSerive;
import org.apache.ibatis.session.SqlSession;


public class MapperFactory {
    public static <T> T getMapper(Class<T> MapperClass) {
        SqlSession sqlSession = DBOperateSerive.getSession();
        return sqlSession.getMapper(MapperClass);
    }
}
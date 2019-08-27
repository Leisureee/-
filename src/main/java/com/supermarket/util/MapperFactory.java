package com.supermarket.util;

import com.supermarket.service.DBOperateService;
import org.apache.ibatis.session.SqlSession;


public class MapperFactory {
    public static <T> T getMapper(Class<T> MapperClass) {
        SqlSession sqlSession = DBOperateService.getSession();
        return sqlSession.getMapper(MapperClass);
    }
}
package com.supermarket.factory;

import com.supermarket.util.SessionManager;
import org.apache.ibatis.session.SqlSession;


@Deprecated
public class MapperFactory {
    public <T> T getMapper(Class<T> MapperClass) {
        SqlSession sqlSession = SessionManager.getSession();
        return sqlSession.getMapper(MapperClass);
    }
}
package com.supermarket.service;

import com.supermarket.util.SessionManager;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName AbstractService
 * @Description <
 * @Author Liar
 * @Date 2019/8/27 18:56
 */
public abstract class AbstractService implements Service {
    
    private SqlSession session;
    
    public AbstractService() {
        this.session = SessionManager.getSession();
    }
    
    public AbstractService(SqlSession session) {
        this.session = session;
    }
    
    protected <T> T getMapper(Class<T> clazz) {
        return session.getMapper(clazz);
    }
    
    @Override
    public void commit() {
        session.commit();
    }
}
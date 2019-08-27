package com.supermarket.service.entityservice;

import com.supermarket.entity.User;
import com.supermarket.mapper.UserMapper;
import com.supermarket.service.AbstractService;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserService
 * @Description <
 * @Author Liar
 * @Date 2019/8/27 18:39
 */
public class UserService extends AbstractService implements UserMapper {
    
    private UserMapper mapper;
    
    public UserService() {
        mapper = getMapper(UserMapper.class);
    }
    
    public UserService(SqlSession session) {
        super(session);
        mapper = session.getMapper(UserMapper.class);
    }
    
    @Override
    public User getUserById(int id) throws SQLException {
        return mapper.getUserById(id);
    }
    
    @Override
    public User getUserByName(String name) throws SQLException {
        return mapper.getUserByName(name);
    }
    
    @Override
    public List<User> getAllUser() throws SQLException {
        return mapper.getAllUser();
    }
    
    @Override
    public User verifyUser(User user) throws SQLException {
        return mapper.verifyUser(user);
    }
    
    @Override
    public void deleteUserById(int id) throws SQLException {
        mapper.deleteUserById(id);
    }
    
    @Override
    public void insertUser(User user) throws SQLException {
        mapper.insertUser(user);
    }
    
    @Override
    public void updateUser(User user) throws SQLException {
        mapper.updateUser(user);
    }
    
}
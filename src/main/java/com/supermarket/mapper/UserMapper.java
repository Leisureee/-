package com.supermarket.mapper;

import com.supermarket.entity.User;

import java.util.List;


public interface UserMapper {
    User getUserByName(String name);
    
    User verifyUser(User user);
    
    /**
     * @Description: get user by id
     * @Date: 2019/6/21 23:21
     * @Param: [id]
     * @Return: com.supermarket.entity.User
     */
    User getUserById(int id);
    
    /**
     * @Author: Griouges
     * @Description: get all user
     * @Date: 2019/6/22 1:33
     * @Param: []
     * @Return: java.util.List<com.supermarket.entity.User>
     */
    List<User> getAllUser();
    
    /**
     * @Author: Griouges
     * @Description: delete user by id
     * @Date: 2019/6/22 1:34
     * @Param: [id]
     * @Return: void
     */
    void deleteUserById(int id);
    
    /**
     * @Author: Griouges
     * @Description: insert a record
     * @Date: 2019/6/22 1:34
     * @Param: [user]
     * @Return: void
     */
    void insertUser(User user);
    
    /**
     * @Author: Griouges
     * @Description: update a record by a new record
     * @Date: 2019/6/22 1:36
     * @Param: [user]
     * @Return: void
     */
    void updateUser(User user);
}

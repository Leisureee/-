package com.supermarket;

import com.supermarket.entity.User;
import com.supermarket.mapper.UserMapper;
import com.supermarket.service.DBOperateService;
import org.apache.ibatis.session.SqlSession;


public class TestMain {
    public static void main(String[] args) {
        SqlSession session = DBOperateService.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("defaultName");
        user.setEmail("example@domain.com");
        if (mapper.verifyUser(user) != null)
            System.out.println("yes");
        System.out.println("no");
    }
}
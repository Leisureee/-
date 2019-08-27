package com.supermarket;

import com.supermarket.service.entityservice.UserService;

import java.sql.SQLException;


public class TestMain {
    public static void main(String[] args) throws SQLException {
        UserService us = new UserService();
        System.out.println(us.getAllUser());
    }
}
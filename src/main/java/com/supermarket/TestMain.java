package com.supermarket;

import com.supermarket.service.support.GoodsService;

import java.sql.SQLException;


public class TestMain {
    public static void main(String[] args) throws SQLException {
        GoodsService service = new GoodsService();
        System.out.println(service.getGoodsById(1));
    }
}
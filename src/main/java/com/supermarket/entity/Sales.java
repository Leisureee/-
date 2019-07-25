package com.supermarket.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName Sales
 * @Description sales实体类
 * @Author Griouges
 * @Date 2019/1/9 11:09
 * @Version V1.0
 */
@Data
public class Sales {
    private String saleNo;
    private String employeeNo;
    private String goodsNo;
    private String vipNo;
    private String name;
    
    private Date date;
    private int num;
    private double price;
}
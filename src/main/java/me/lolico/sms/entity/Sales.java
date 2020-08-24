package me.lolico.sms.entity;

import lombok.Data;

import java.sql.Date;

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
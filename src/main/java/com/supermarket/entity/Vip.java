package com.supermarket.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName vip
 * @Description vip实体类
 * @Author Griouges
 * @Date 2019/1/8 15:37
 * @Version V1.0
 */

@Data
public class Vip {
    private int id;
    private String no;
    private String name;
    private String password;
    private Date registerDate;
    private double balance;
}
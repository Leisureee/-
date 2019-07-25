package com.supermarket.entity;

import lombok.Data;

/**
 * @ClassName Employee
 * @Description employee实体类
 * @Author Griouges
 * @Date 2019/1/8 15:33
 * @Version V1.0
 */

@Data
public class Employee {
    private int id;
    private String no;
    private String category;
    private String name;
    private String sex;
    private String tel;
    private int age;
    private double wage;
}
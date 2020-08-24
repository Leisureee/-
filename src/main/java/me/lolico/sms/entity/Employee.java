package me.lolico.sms.entity;

import lombok.Data;

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
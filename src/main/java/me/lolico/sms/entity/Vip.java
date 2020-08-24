package me.lolico.sms.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Vip {
    private int id;
    private String no;
    private String name;
    private String password;
    private Date registerDate;
    private double balance;
}
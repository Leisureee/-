package me.lolico.sms.entity;

import lombok.Data;


@Data
public class Goods {
    private int id;
    private String no;
    private String name;
    private String category;
    private int inventory;
    private double price;
    private double purchasePrice;
}
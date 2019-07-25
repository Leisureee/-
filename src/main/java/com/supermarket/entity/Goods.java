package com.supermarket.entity;

import lombok.Data;

/**
 * @ClassName goods
 * @Description goods实体类
 * @Author Griouges
 * @Date 2019/1/6 16:25
 * @Version V1.0
 */

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
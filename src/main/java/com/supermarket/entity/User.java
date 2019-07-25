package com.supermarket.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description user实体类
 * @Author Griouges
 * @Date 2019/1/8 20:58
 * @Version V1.0
 */

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
}
package com.supermarket.mapper;

import com.supermarket.entity.Vip;

import java.util.List;

public interface VipMapper {
    Vip getVipById(int id);
    
    List<Vip> getAllVip();
    
    void insertVip(Vip vip);
    
    void deleteVipById(int id);
    
    void updateVip(Vip vip);
}

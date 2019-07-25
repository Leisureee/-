package com.supermarket.mapper;

import com.supermarket.entity.Goods;

import java.util.List;

public interface GoodsMapper {
    void insertGoods(Goods goods);
    
    void updateGoods(Goods goods);
    
    void deleteGoodsById(int id);
    
    List<Goods> getAllGoods();
    
    Goods getGoodsById(int id);
}

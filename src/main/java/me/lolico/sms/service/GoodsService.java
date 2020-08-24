package me.lolico.sms.service;


import me.lolico.sms.entity.Goods;
import me.lolico.sms.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GoodsService {

    private final GoodsMapper mapper;

    public GoodsService(GoodsMapper mapper) {
        this.mapper = mapper;
    }

    public Goods getGoodsById(int id) throws SQLException {
        return mapper.getGoodsById(id);
    }

    public List<Goods> getAllGoods() throws SQLException {
        return mapper.getAllGoods();
    }

    public void insertGoods(Goods goods) throws SQLException {
        mapper.insertGoods(goods);
    }

    public void deleteGoodsById(int id) throws SQLException {
        mapper.deleteGoodsById(id);
    }

    public void updateGoods(Goods goods) throws SQLException {
        mapper.updateGoods(goods);
    }

}
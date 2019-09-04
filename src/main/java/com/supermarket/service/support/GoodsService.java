package com.supermarket.service.support;

import com.supermarket.entity.Goods;
import com.supermarket.mapper.GoodsMapper;
import com.supermarket.service.AbstractService;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName GoodsService
 * @Description <
 * @Author Liar
 * @Date 2019/8/27 18:38
 */
public class GoodsService extends AbstractService implements GoodsMapper {
    
    private GoodsMapper mapper;
    
    public GoodsService() {
        mapper = getMapper(GoodsMapper.class);
    }
    
    public GoodsService(SqlSession session) {
        super(session);
        mapper = session.getMapper(GoodsMapper.class);
    }
    
    @Override
    public Goods getGoodsById(int id) throws SQLException {
        return mapper.getGoodsById(id);
    }
    
    @Override
    public List<Goods> getAllGoods() throws SQLException {
        return mapper.getAllGoods();
    }
    
    @Override
    public void insertGoods(Goods goods) throws SQLException {
        mapper.insertGoods(goods);
    }
    
    @Override
    public void deleteGoodsById(int id) throws SQLException {
        mapper.deleteGoodsById(id);
    }
    
    @Override
    public void updateGoods(Goods goods) throws SQLException {
        mapper.updateGoods(goods);
    }
    
}
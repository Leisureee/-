package com.supermarket.service.support;

import com.supermarket.entity.Vip;
import com.supermarket.mapper.VipMapper;
import com.supermarket.service.AbstractService;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName VipService
 * @Description <
 * @Author Liar
 * @Date 2019/8/27 19:09
 */
public class VipService extends AbstractService implements VipMapper {
    
    private VipMapper mapper;
    
    public VipService() {
        mapper = getMapper(VipMapper.class);
    }
    
    public VipService(SqlSession session) {
        super(session);
        mapper = session.getMapper(VipMapper.class);
    }
    
    @Override
    public Vip getVipById(int id) throws SQLException {
        return mapper.getVipById(id);
    }
    
    @Override
    public List<Vip> getAllVip() throws SQLException {
        return mapper.getAllVip();
    }
    
    @Override
    public void insertVip(Vip vip) throws SQLException {
        mapper.insertVip(vip);
    }
    
    @Override
    public void deleteVipById(int id) throws SQLException {
        mapper.deleteVipById(id);
    }
    
    @Override
    public void updateVip(Vip vip) throws SQLException {
        mapper.updateVip(vip);
    }
}
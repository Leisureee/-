package me.lolico.sms.service;

import me.lolico.sms.entity.Vip;
import me.lolico.sms.mapper.VipMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class VipService {

    private final VipMapper mapper;

    public VipService(VipMapper mapper) {
        this.mapper = mapper;
    }

    public Vip getVipById(int id) throws SQLException {
        return mapper.getVipById(id);
    }

    public List<Vip> getAllVip() throws SQLException {
        return mapper.getAllVip();
    }

    public void insertVip(Vip vip) throws SQLException {
        mapper.insertVip(vip);
    }

    public void deleteVipById(int id) throws SQLException {
        mapper.deleteVipById(id);
    }

    public void updateVip(Vip vip) throws SQLException {
        mapper.updateVip(vip);
    }
}
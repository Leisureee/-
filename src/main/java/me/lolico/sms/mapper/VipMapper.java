package me.lolico.sms.mapper;


import me.lolico.sms.entity.Vip;

import java.sql.SQLException;
import java.util.List;

public interface VipMapper {
    /**
     * 根据id在数据库中查找vip
     *
     * @param id
     * @return 查找到的结果
     * @throws SQLException
     */
    Vip getVipById(int id) throws SQLException;

    /**
     * 获取全部的vip
     *
     * @return 查询结果集
     * @throws SQLException
     */
    List<Vip> getAllVip() throws SQLException;

    /**
     * 插入一条记录
     *
     * @param vip
     * @throws SQLException
     */
    void insertVip(Vip vip) throws SQLException;

    /**
     * 根据id删除一条记录
     *
     * @param id
     * @throws SQLException
     */
    void deleteVipById(int id) throws SQLException;

    /**
     * 根据id查找vip并更新信息
     *
     * @param vip
     * @throws SQLException
     */
    void updateVip(Vip vip) throws SQLException;
}

package me.lolico.sms.mapper;


import me.lolico.sms.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsMapper {
    /**
     * 根据id在数据库中查找goods
     *
     * @param id
     * @return 查找到的结果
     * @throws SQLException
     */
    Goods getGoodsById(int id) throws SQLException;

    /**
     * 获取全部的goods
     *
     * @return 查询结果集
     * @throws SQLException
     */
    List<Goods> getAllGoods() throws SQLException;

    /**
     * 插入一条记录
     *
     * @param goods
     * @throws SQLException
     */
    void insertGoods(Goods goods) throws SQLException;

    /**
     * 根据id删除一条记录
     *
     * @param id
     * @throws SQLException
     */
    void deleteGoodsById(int id) throws SQLException;

    /**
     * 根据id查找goods并更新信息
     *
     * @param goods
     * @throws SQLException
     */
    void updateGoods(Goods goods) throws SQLException;
}

package me.lolico.sms.mapper;


import me.lolico.sms.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;


@Mapper
public interface UserMapper {
    /**
     * 根据id在数据库中查找user
     *
     * @param id
     * @return 查找到的结果
     * @throws SQLException
     */
    User getUserById(int id) throws SQLException;

    /**
     * 根据name在数据库中查找user
     *
     * @param name
     * @return 查找到的结果
     * @throws SQLException
     */
    User getUserByName(String name) throws SQLException;

    /**
     * 获取全部的user
     *
     * @return 查询结果集
     * @throws SQLException
     */
    List<User> getAllUser() throws SQLException;

    /**
     * 根据user.name和user.password查询
     *
     * @param user
     * @return 查询的结果
     * @throws SQLException
     */
    User verifyUser(User user) throws SQLException;

    /**
     * 根据id删除一条记录
     *
     * @param id
     * @throws SQLException
     */
    void deleteUserById(int id) throws SQLException;

    /**
     * 插入一条记录
     *
     * @param user
     * @throws SQLException
     */
    void insertUser(User user) throws SQLException;

    /**
     * 根据id查找user并更新信息
     *
     * @param user
     * @throws SQLException
     */
    void updateUser(User user) throws SQLException;
}

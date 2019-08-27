package com.supermarket.mapper;

import com.supermarket.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeMapper {
    /**
     * 根据id在数据库中查找employee
     * @param id
     * @return 查找到的结果
     * @throws SQLException
     */
    Employee getEmployeeById(int id) throws SQLException;
    
    /**
     * 获取全部的employee
     * @return 查询结果集
     * @throws SQLException
     */
    List<Employee> getAllEmployee() throws SQLException;
    
    /**
     * 插入一条记录
     * @param employee
     * @throws SQLException
     */
    void insertEmployee(Employee employee) throws SQLException;
    
    /**
     * 根据id删除一条记录
     * @param id
     * @throws SQLException
     */
    void deleteEmployeeById(int id) throws SQLException;
    
    /**
     * 根据id查找employee并更新信息
     * @param employee
     * @throws SQLException
     */
    void updateEmployee(Employee employee) throws SQLException;
}

package com.supermarket.mapper;

import com.supermarket.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     * @Author: Griouges
     * @Description:
     * @Date: 2019/6/22 2:58
     * @Param: [id]
     * @Return: com.supermarket.entity.Employee
     */
    Employee getEmployeeById(int id);
    
    /**
     * @Author: Griouges
     * @Description:
     * @Date: 2019/6/22 1:46
     * @Param: []
     * @Return: java.util.List<com.supermarket.entity.Employee>
     */
    List<Employee> getAllEmployee();
    
    /**
     * @Author: Griouges
     * @Description:
     * @Date: 2019/6/22 1:47
     * @Param: [employee]
     * @Return: void
     */
    void insertEmployee(Employee employee);
    
    /**
     * @Author: Griouges
     * @Description:
     * @Date: 2019/6/22 1:48
     * @Param: [employee]
     * @Return: void
     */
    void deleteEmployeeById(int id);
    
    /**
     * @Author: Griouges
     * @Description:
     * @Date: 2019/6/22 1:48
     * @Param: [employee]
     * @Return: void
     */
    void updateEmployee(Employee employee);
}

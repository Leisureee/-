package com.supermarket.service.support;

import com.supermarket.entity.Employee;
import com.supermarket.mapper.EmployeeMapper;
import com.supermarket.service.AbstractService;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description <
 * @Author Liar
 * @Date 2019/8/27 18:10
 */
public class EmployeeService extends AbstractService implements EmployeeMapper {
    
    private EmployeeMapper mapper;
    
    public EmployeeService() {
        mapper = getMapper(EmployeeMapper.class);
    }
    
    public EmployeeService(SqlSession session) {
        super(session);
        mapper = session.getMapper(EmployeeMapper.class);
    }
    
    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        return mapper.getEmployeeById(id);
    }
    
    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        return mapper.getAllEmployee();
    }
    
    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        mapper.insertEmployee(employee);
    }
    
    @Override
    public void deleteEmployeeById(int id) throws SQLException {
        mapper.deleteEmployeeById(id);
    }
    
    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        mapper.updateEmployee(employee);
    }
    
}
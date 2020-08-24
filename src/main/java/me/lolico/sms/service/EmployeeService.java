package me.lolico.sms.service;

import me.lolico.sms.entity.Employee;
import me.lolico.sms.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    public Employee getEmployeeById(int id) throws SQLException {
        return mapper.getEmployeeById(id);
    }

    public List<Employee> getAllEmployee() throws SQLException {
        return mapper.getAllEmployee();
    }

    public void insertEmployee(Employee employee) throws SQLException {
        mapper.insertEmployee(employee);
    }

    public void deleteEmployeeById(int id) throws SQLException {
        mapper.deleteEmployeeById(id);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        mapper.updateEmployee(employee);
    }

}
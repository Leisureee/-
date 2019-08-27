package com.supermarket.controller;

import com.supermarket.entity.Employee;
import com.supermarket.mapper.EmployeeMapper;
import com.supermarket.service.DBOperateService;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        SqlSession session = DBOperateService.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        switch (action) {
            case "show": {
                List<Employee> employeeList = mapper.getAllEmployee();
                request.setAttribute("employeeList", employeeList);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
                break;
            }
            case "delete": {
                mapper.deleteEmployeeById(Integer.parseInt(request.getParameter("id")));
                session.commit();
                List<Employee> employeeList = mapper.getAllEmployee();
                request.setAttribute("employeeList", employeeList);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
                break;
            }
            case "update": {
                Employee employee = getEmployeeFromRequest(request, false);
                mapper.updateEmployee(employee);
                session.commit();
                List<Employee> employeeList = mapper.getAllEmployee();
                request.setAttribute("employeeList", employeeList);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
                break;
            }
            case "insert": {
                Employee employee = getEmployeeFromRequest(request, true);
                mapper.insertEmployee(employee);
                session.commit();
                List<Employee> employeeList = mapper.getAllEmployee();
                request.setAttribute("employeeList", employeeList);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
    
    private Employee getEmployeeFromRequest(HttpServletRequest request, Boolean notHaveId) {
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String tel = request.getParameter("tel");
        double wage = Double.parseDouble(request.getParameter("wage"));
        Employee employee = new Employee();
        employee.setAge(age);
        employee.setCategory(category);
        employee.setName(name);
        employee.setNo(no);
        employee.setSex(sex);
        employee.setTel(tel);
        employee.setWage(wage);
        
        if (!notHaveId) {
            int id = Integer.parseInt(request.getParameter("id"));
            employee.setId(id);
            return employee;
        }
        return employee;
    }
}

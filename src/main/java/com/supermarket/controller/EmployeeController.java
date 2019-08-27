package com.supermarket.controller;

import com.supermarket.entity.Employee;
import com.supermarket.service.entityservice.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
    
        EmployeeService service = new EmployeeService();
    
        try {
            switch (action) {
                case "show": {
                    List<Employee> employeeList = service.getAllEmployee();
                    request.setAttribute("employeeList", employeeList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                case "delete": {
                    service.deleteEmployeeById(Integer.parseInt(request.getParameter("id")));
                    service.commit();
                    List<Employee> employeeList = service.getAllEmployee();
                    request.setAttribute("employeeList", employeeList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                case "update": {
                    Employee employee = getEmployeeFromRequest(request, false);
                    service.updateEmployee(employee);
                    service.commit();
                    List<Employee> employeeList = service.getAllEmployee();
                    request.setAttribute("employeeList", employeeList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                case "insert": {
                    Employee employee = getEmployeeFromRequest(request, true);
                    service.insertEmployee(employee);
                    service.commit();
                    List<Employee> employeeList = service.getAllEmployee();
                    request.setAttribute("employeeList", employeeList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

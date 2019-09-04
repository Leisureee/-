package com.supermarket.controller;

import com.supermarket.entity.User;
import com.supermarket.service.support.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserController", urlPatterns = "/UserController")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserService service = new UserService();
    
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        PrintWriter out = response.getWriter();
        try {
            switch (action) {
                case "login": {
                    if (service.verifyUser(user) != null) {
                        user = service.verifyUser(user);
                        request.getSession().setAttribute("user", user);
                        request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("index.jsp?status=1");
                    }
                    break;
                }
                case "register": {
                    if (service.getUserByName(name) != null) {
                        response.sendRedirect("index.jsp?status=2");
                    } else {
                        String email = request.getParameter("email");
                        user.setEmail(email);
                        service.insertUser(user);
                        service.commit();
                        response.sendRedirect("index.jsp?status=3");
                    }
                    break;
                }
                case "exit": {
                    request.getSession().removeAttribute("user");
                    response.sendRedirect("index.jsp");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

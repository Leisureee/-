package com.supermarket.controller;

import com.supermarket.entity.User;
import com.supermarket.mapper.UserMapper;
import com.supermarket.service.DBOperateSerive;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserController", urlPatterns = "/UserController")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = DBOperateSerive.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        PrintWriter out = response.getWriter();
        switch (action) {
            case "login": {
                if (mapper.verifyUser(user) != null) {
                    user = mapper.verifyUser(user);
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                } else {
                    response.sendRedirect("index.jsp?status=1");
                }
                break;
            }
            case "register": {
                if (mapper.getUserByName(name) != null) {
                    response.sendRedirect("index.jsp?status=2");
                } else {
                    String email = request.getParameter("email");
                    user.setEmail(email);
                    mapper.insertUser(user);
                    session.commit();
                    response.sendRedirect("index.jsp?status=3");
                }
                break;
            }
            case "exit": {
                request.getSession().removeAttribute("user");
                response.sendRedirect("index.jsp");
            }
        }
    }
}

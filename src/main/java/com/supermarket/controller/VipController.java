package com.supermarket.controller;

import com.supermarket.entity.Vip;
import com.supermarket.service.entityservice.VipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "VipController", urlPatterns = "/VipController")
public class VipController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VipService service = new VipService();
    
        String action = request.getParameter("action");
    
        try {
            switch (action) {
                case "show": {
                    List<Vip> vipList = service.getAllVip();
                    request.setAttribute("vipList", vipList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                case "delete": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    service.deleteVipById(id);
                    service.commit();
                    List<Vip> vipList = service.getAllVip();
                    request.setAttribute("vipList", vipList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                case "update": {
                    Vip vip = getVipFromRequest(request, false);
                    service.updateVip(vip);
                    service.commit();
                    List<Vip> vipList = service.getAllVip();
                    request.setAttribute("vipList", vipList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
                case "insert": {
                    Vip vip = getVipFromRequest(request, true);
                    service.insertVip(vip);
                    service.commit();
                    service.commit();
                    List<Vip> vipList = service.getAllVip();
                    request.setAttribute("vipList", vipList);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Vip getVipFromRequest(HttpServletRequest request, Boolean notHaveId) {
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        double balance = Double.parseDouble(request.getParameter("balance"));
        Date registerDate = Date.valueOf(request.getParameter("registerDate"));
        Vip vip = new Vip();
        vip.setBalance(balance);
        vip.setName(name);
        vip.setNo(no);
        vip.setPassword(password);
        vip.setRegisterDate(registerDate);
        if (!notHaveId) {
            int id = Integer.parseInt(request.getParameter("id"));
            vip.setId(id);
            return vip;
        }
        return vip;
    }
}

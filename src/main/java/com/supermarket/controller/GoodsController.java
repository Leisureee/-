package com.supermarket.controller;

import com.supermarket.entity.Goods;
import com.supermarket.service.entityservice.GoodsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GoodsController", urlPatterns = "/GoodsController")
public class GoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
    
        GoodsService service = new GoodsService();
    
        try {
            switch (action) {
                case "show": {
                    List<Goods> goodsList = service.getAllGoods();
                    request.setAttribute("goodsList", goodsList);
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "delete": {
                    service.deleteGoodsById(Integer.parseInt(request.getParameter("id")));
                    service.commit();
                    List<Goods> goodsList = service.getAllGoods();
                    request.setAttribute("goodsList", goodsList);
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "update": {
                    Goods goods = getUserFromRequest(request, false);
                    service.updateGoods(goods);
                    service.commit();
                    List<Goods> goodsList = service.getAllGoods();
                    request.setAttribute("goodsList", goodsList);
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "insert": {
                    Goods goods = getUserFromRequest(request, true);
                    service.insertGoods(goods);
                    service.commit();
                    List<Goods> goodsList = service.getAllGoods();
                    request.setAttribute("goodsList", goodsList);
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Goods getUserFromRequest(HttpServletRequest request, boolean notHaveId) {
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        double pprice = Double.parseDouble(request.getParameter("pprice"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        Goods goods = new Goods();
        goods.setNo(no);
        goods.setName(name);
        goods.setCategory(category);
        goods.setPrice(price);
        goods.setPurchasePrice(pprice);
        goods.setInventory(inventory);
        if (!notHaveId) {
            int id = Integer.parseInt(request.getParameter("id"));
            goods.setId(id);
            return goods;
        }
        return goods;
    }
}
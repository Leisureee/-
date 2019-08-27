package com.supermarket.controller;

import com.supermarket.entity.Goods;
import com.supermarket.mapper.GoodsMapper;
import com.supermarket.service.DBOperateService;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsController", urlPatterns = "/GoodsController")
public class GoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        SqlSession session = DBOperateService.getSession();
        GoodsMapper mapper = session.getMapper(GoodsMapper.class);
        switch (action) {
            case "show": {
                List<Goods> goodsList = mapper.getAllGoods();
                request.setAttribute("goodsList", goodsList);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
                break;
            }
            case "delete": {
                mapper.deleteGoodsById(Integer.parseInt(request.getParameter("id")));
                session.commit();
                List<Goods> goodsList = mapper.getAllGoods();
                request.setAttribute("goodsList", goodsList);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
                break;
            }
            case "update": {
                Goods goods = getUserFromRequest(request, false);
                mapper.updateGoods(goods);
                session.commit();
                List<Goods> goodsList = mapper.getAllGoods();
                request.setAttribute("goodsList", goodsList);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
                break;
            }
            case "insert": {
                Goods goods = getUserFromRequest(request, true);
                mapper.insertGoods(goods);
                session.commit();
                List<Goods> goodsList = mapper.getAllGoods();
                request.setAttribute("goodsList", goodsList);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            }
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
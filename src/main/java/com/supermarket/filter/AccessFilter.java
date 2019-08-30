package com.supermarket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AccessFilter", urlPatterns = {"/*"})
public class AccessFilter implements Filter {
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String url = ((HttpServletRequest) req).getServletPath();
        // String method = ((HttpServletRequest) req).getMethod();
        // System.out.println(url+"-"+method);
        // if (url.equals("/index.jsp") || url.equals("/") || (url.contains("/UserController") && method.equalsIgnoreCase("post"))) {
        //     chain.doFilter(req, resp);
        //     return;
        // } else if (((HttpServletRequest) req).getSession().getAttribute("user") == null) {
        //     HttpServletResponse response = (HttpServletResponse) resp;
        //     response.sendRedirect("index.jsp?status=4");
        //     return;
        // }
    
        String[] controllerUrl = new String[]{"/GoodsController", "/EmployeeController", "/VipController"};
        boolean isControllerUrl = false;
        for (String s : controllerUrl) {
            if (url.equals(s)) {
                isControllerUrl = true;
                break;
            }
        }
        if (isControllerUrl && ((HttpServletRequest) req).getSession().getAttribute("user") == null) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("index.jsp?status=4");
            return;
        }
        chain.doFilter(req, resp);
    }
    
    public void init(FilterConfig config) throws ServletException {
    }
    
}

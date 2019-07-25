package com.supermarket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AccessFilter", urlPatterns = {"/welcome.jsp"})
public class AccessFilter implements Filter {
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req.getAttribute("user") == null) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("index.jsp?status=4");
        }
        chain.doFilter(req, resp);
    }
    
    public void init(FilterConfig config) throws ServletException {
    }
    
}

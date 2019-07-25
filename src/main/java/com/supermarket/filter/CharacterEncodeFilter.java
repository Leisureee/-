package com.supermarket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "CharacterEncodeFilter", urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "charset", value = "utf-8"),
        @WebInitParam(name = "contentType", value = "text/html;charset=utf-8")
})
public class CharacterEncodeFilter implements Filter {
    private String charset;
    private String contentType;
    
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(charset);
        resp.setCharacterEncoding(charset);
        resp.setContentType(contentType);
        
        ServletRequest request = (ServletRequest) Proxy.newProxyInstance(
                req.getClass().getClassLoader(),
                req.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (method.getName().equals("getParameter") && ((HttpServletRequest) req).getMethod().equalsIgnoreCase("GET")) {
                        String parameter = (String) method.invoke(req, args);
                        parameter = new String(parameter.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                        return parameter;
                    }
                    return method.invoke(req, args);
                }
        );
        chain.doFilter(req, resp);
    }
    
    public void init(FilterConfig config) throws ServletException {
        charset = config.getInitParameter("charset");
        contentType = config.getInitParameter("contentType");
    }
    
}

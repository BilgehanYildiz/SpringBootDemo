package com.demo.bootcamp.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Örnek Senaryo 10 Filter Kullanımı
@Component
@Order(1)
public class MyLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Logging Request" + req.getMethod()+ req.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("Logging Response :{}"+ res.getContentType());
    }

}

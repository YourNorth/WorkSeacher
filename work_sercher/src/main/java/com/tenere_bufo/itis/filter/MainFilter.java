package com.tenere_bufo.itis.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String test = request.getRequestURI();
        if (test.equals("/signUp") || test.startsWith("/css") || test.startsWith("/img") ||
                test.startsWith("/fonts") || test.startsWith("/js") || test.startsWith("/scss")){
            filterChain.doFilter(request, response);
            return;
        }
        if (session == null || session.getAttribute("email") == null){
            request.getRequestDispatcher("/signIn").forward(request, response);
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}

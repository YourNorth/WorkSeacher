package com.tenere_bufo.itis.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/elements", "/blog", "/contact", "/index", "/job_details", "/single_blog", "/company/*", "/jobs",
                "/candidate", "/candidate/*"}
)
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
        if (session == null || session.getAttribute("email") == null){
            response.sendRedirect(request.getContextPath() + "/signIn");
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}

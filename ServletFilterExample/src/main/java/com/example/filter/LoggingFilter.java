package com.example.filter;

import java.io.IOException;
import java.util.Date;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/hello")  // Filter mapped to /hello
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Log before servlet executes
        System.out.println("=== Filter Before Servlet ===");
        System.out.println("Filter Name: LoggingFilter");
        System.out.println("Filter Class: " + this.getClass().getName());
        System.out.println("Request Time: " + new Date());
        System.out.println("Client IP: " + request.getRemoteAddr());
        System.out.println("=============================");

        // Continue request
        chain.doFilter(request, response);

        // Log after servlet executes
        System.out.println("=== Filter After Servlet ===");
        System.out.println("Response Time: " + new Date());
        System.out.println("============================");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}

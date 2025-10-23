package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Print metadata in console
        System.out.println("=== Servlet Metadata ===");
        System.out.println("Servlet Name: " + getServletName());
        System.out.println("Servlet Class: " + this.getClass().getName());
        System.out.println("Client IP: " + request.getRemoteAddr());
        System.out.println("Requested URL: " + request.getRequestURI());
        System.out.println("Protocol: " + request.getProtocol());
        System.out.println("========================");

        // Response to browser
        response.setContentType("text/html");
        response.getWriter().println("<h2>Welcome to Jakarta Servlet!</h2>");
        response.getWriter().println("<p>Servlet Name: " + getServletName() + "</p>");
        response.getWriter().println("<p>Servlet Class: " + this.getClass().getName() + "</p>");
        response.getWriter().println("<p>Client IP: " + request.getRemoteAddr() + "</p>");
        response.getWriter().println("<p>Requested URL: " + request.getRequestURI() + "</p>");
        response.getWriter().println("<p>Protocol: " + request.getProtocol() + "</p>");
    }
}

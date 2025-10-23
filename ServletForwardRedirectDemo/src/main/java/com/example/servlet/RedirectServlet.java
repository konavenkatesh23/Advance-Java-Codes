package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Redirect to WelcomeServlet (within app)
        response.sendRedirect("WelcomeServlet");

        // OR redirect to an external site
        // response.sendRedirect("https://www.google.com");
    }
}

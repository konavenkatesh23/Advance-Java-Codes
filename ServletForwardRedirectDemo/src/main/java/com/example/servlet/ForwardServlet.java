package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("username", "Venkatesh");

        RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
        dispatcher.forward(request, response);
    }
}

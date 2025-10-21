package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aaa")
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if ("Kona Venkatesh".equals(name)) {
            if ("12345".equals(password)) {
                // Redirect to home.html on successful login
                resp.sendRedirect("home.html");
            } else {
                resp.setContentType("text/html");
                resp.getWriter().println("<h1>Login Failed</h1>");
                resp.getWriter().println("<p>Invalid password. Please <a href='index.html'>try again</a>.</p>");
            }
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("<h1>Login Failed</h1>");
            resp.getWriter().println("<p>Invalid username. Please <a href='index.html'>try again</a>.</p>");
        }
    }
}

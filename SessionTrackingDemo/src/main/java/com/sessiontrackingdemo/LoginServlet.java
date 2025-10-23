package com.sessiontrackingdemo;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uname = request.getParameter("uname");

        // Create a Cookie
        Cookie ck = new Cookie("user", uname);
        response.addCookie(ck);

        // Create HTTP Session
        HttpSession session = request.getSession();
        session.setAttribute("user", uname);

        // Redirect to dashboard
        response.sendRedirect("dashboard.jsp");
    }
}

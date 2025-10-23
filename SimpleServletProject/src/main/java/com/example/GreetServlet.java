package com.example;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        request.setAttribute("username", name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
        dispatcher.forward(request, response);
    }
}

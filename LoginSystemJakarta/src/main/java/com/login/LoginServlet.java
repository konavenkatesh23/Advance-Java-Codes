package com.login;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

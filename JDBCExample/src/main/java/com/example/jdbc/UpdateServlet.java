package com.example.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE students SET email=? WHERE id=?");
            ps.setString(1, email);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            response.getWriter().println(rows + " record(s) updated.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

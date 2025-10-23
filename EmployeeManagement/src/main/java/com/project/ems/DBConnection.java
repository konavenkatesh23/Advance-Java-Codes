package com.project.ems;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/emdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change as needed

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

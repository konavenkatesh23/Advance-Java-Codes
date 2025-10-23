package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Connect to st_db database
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/st_db", "root", "root");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

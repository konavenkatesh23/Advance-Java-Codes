package com.project.ems;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = DBConnection.getConnection();

        if (conn == null) {
            System.out.println("Connection failed!");
            return;
        }

        try {
            while (true) {
                System.out.println("\n--- Employee Management ---");
                System.out.println("1. Insert Employee");
                System.out.println("2. Get Employee Salary");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    String insertSQL = "INSERT INTO employees (name, salary) VALUES (?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                    pstmt.setString(1, name);
                    pstmt.setDouble(2, salary);
                    int rows = pstmt.executeUpdate();
                    System.out.println(rows + " employee inserted successfully!");

                } else if (choice == 2) {
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    String selectSQL = "SELECT name, salary FROM employees WHERE id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(selectSQL);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        System.out.println("Employee Name: " + rs.getString("name"));
                        System.out.println("Employee Salary: " + rs.getDouble("salary"));
                    } else {
                        System.out.println("Employee not found!");
                    }

                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }

            conn.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

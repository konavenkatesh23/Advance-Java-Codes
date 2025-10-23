package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Student;

public class StudentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/db_stud";
    private String jdbcUsername = "root";  // change to your DB username
    private String jdbcPassword = "password"; // change to your DB password

    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_STUDENT_BY_ID = "SELECT id, name, email, country FROM students WHERE id = ?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM students WHERE id = ?";
    private static final String UPDATE_STUDENT_SQL = "UPDATE students SET name = ?, email = ?, country = ? WHERE id = ?";

    public StudentDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertStudent(Student student) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCountry());
            preparedStatement.executeUpdate();
        }
    }

    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                student = new Student(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                students.add(new Student(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getCountry());
            statement.setInt(4, student.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}

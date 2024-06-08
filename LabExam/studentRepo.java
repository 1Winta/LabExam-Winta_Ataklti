package student;

public class studentRepo {


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepo {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String password = "password";

    public void createDBAndTable() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String createDatabase = "CREATE DATABASE IF NOT EXISTS LabExamDB";
            stmt.executeUpdate(createDatabase);

            String useDatabase = "USE LabExamDB";
            stmt.executeUpdate(useDatabase);

            String createTable = "CREATE TABLE IF NOT EXISTS Student (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "email VARCHAR(50))";
            stmt.executeUpdate(createTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoTable(Student student) {
        try (Connection conn = DriverManager.getConnection(url + "LabExamDB", user, password);
             Statement stmt = conn.createStatement()) {

            String insertStudent = String.format("INSERT INTO Student (name, email) VALUES ('%s', '%s')",
                    student.getName(), student.getEmail());
            stmt.executeUpdate(insertStudent);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}
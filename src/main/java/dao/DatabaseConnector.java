package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/thuc_hanh_md3?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "260797";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL driver");
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu", e);
        }
        return connection;
    }

}
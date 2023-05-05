package org.bootcamp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jbdc:mysql://localhost:3306/javaweb?serverTimezone=America/Santiago";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

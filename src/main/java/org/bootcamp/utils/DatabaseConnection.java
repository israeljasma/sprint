package org.bootcamp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String URL = "jbdc:mysql://localhost:3306/javaweb?serverTimezone=America/Santiago";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        //return DriverManager.getConnection(url, username, password);
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?serverTimezone=America/Santiago", "root", "");
    }
}

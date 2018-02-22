package com.lynda.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/20/18.
 */
public class DBUtil {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/explorecalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case MYSQL:
                return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            default:
                return null;
        }
    }

    public static void processException(SQLException e){
        System.err.println("SQL state: " + e.getSQLState());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("Error message: " + e.getMessage());
    }
}

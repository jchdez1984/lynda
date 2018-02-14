package com.lynda.training.com.lynda.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/14/18.
 */
public class DBUtil {
    private static String M_CONN_STRING = "jdbc:mysql://localhost:3306/explorecalifornia";
    private static String H_CONN_STRING = "jdbc:mysql://localhost:3306/explorecalifornia";
    private static String USER = "dbuser";
    private static String PASSWORD = "dbpassword";

    public static Connection getConnection(DBType dbType) throws SQLException{
        switch (dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USER, PASSWORD);
            case HSQL:
                return DriverManager.getConnection(H_CONN_STRING, USER, PASSWORD);
            default: return null;
        }
    }

    public static void processException(SQLException e){
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getMessage());
        System.err.println("SQL State: " + e.getSQLState());
    }
}

package com.lynda.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/19/18.
 */
public class DBUtil {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost:3306/explorecalifornia";
    private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException{
        switch (dbType){
            case MYSLQ:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
            case HSQL:
                return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
            default: return null;
        }
    }

    public static void processException(SQLException e){
        System.err.println("Error: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());
        System.err.println("SQL state: " + e.getSQLState());
    }


}

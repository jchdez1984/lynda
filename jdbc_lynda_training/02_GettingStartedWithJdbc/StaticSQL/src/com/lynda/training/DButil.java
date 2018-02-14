package com.lynda.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/14/18.
 */
public class DButil {

    private static final java.lang.String M_CONN_STRING = "jdbc:mysql://localhost:3306/explorescalifornia";
    private static final java.lang.String H_CONN_STRING = "jdbc:Hsqldb:data/explorescalifornia";
    private static final java.lang.String USER = "jdbc:mysql://localhost:3306/explorescalifornia";
    private static final java.lang.String PASSWORD = "jdbc:mysql://localhost:3306/explorescalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException{
        switch (dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USER, PASSWORD);
            case HSQL: DriverManager.getConnection(H_CONN_STRING, USER, PASSWORD);

            default: return null;
        }
    }

    public static void processException(SQLException e){
        System.err.println("Error message: " + e.getMessage());
        System.err.println("State: " + e.getSQLState());
        System.err.println("Error Code: " + e.getErrorCode());
    }
}

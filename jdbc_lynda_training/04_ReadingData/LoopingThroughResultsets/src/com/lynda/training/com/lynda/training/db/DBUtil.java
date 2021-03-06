package com.lynda.training.com.lynda.training.db;

import com.lynda.training.com.lynda.training.db.DBType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/14/18.
 */
public class DBUtil {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException{
        switch (dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
            case HSQL:
                return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
            default: return null;
        }
    }
}

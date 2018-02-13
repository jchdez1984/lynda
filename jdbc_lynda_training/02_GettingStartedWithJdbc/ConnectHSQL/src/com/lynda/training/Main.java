package com.lynda.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static String USERNAME = "dbuser";
    private static String PASSWORD = "dbpassword";
    private static String CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println("The error is: " + e);
        } finally{
            if(conn != null){
                conn.close();
            }
        }

    }
}

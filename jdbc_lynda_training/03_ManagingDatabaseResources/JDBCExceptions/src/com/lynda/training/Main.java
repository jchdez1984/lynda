package com.lynda.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        try{
            conn = DBUtil.getConnection(DBType.MYSQL);
            System.out.println("Connected!");
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }
}

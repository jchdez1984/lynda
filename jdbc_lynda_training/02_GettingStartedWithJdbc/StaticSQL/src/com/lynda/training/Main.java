package com.lynda.training;

import java.sql.*;

public class Main {

    private static String USERNAME = "dbuser";
    private static String PASSWORD = "dbpassword";
    private static String CONN_STRING = "jdbc:mysql://localhost:3306/explorecalifornia";
    private static final String SQL = "SELECT * FROM states";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(SQL);

            rs.last();
            int nRows = rs.getRow();
            System.out.println("number of retrieved rows : " + nRows);
        } catch (SQLException e) {
            System.err.println("The error is: " + e);
        } finally{
            if(conn != null){
                conn.close();
            }

            if(stmt !=  null){
                stmt.close();
            }

            if(rs != null){
                rs.close();
            }
        }

    }
}

package com.lynda.training;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
       try(
               Connection conn = DBUtil.getConnection(DBType.MYSQL);
               Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs = stmt.executeQuery("select * FROM states;");
               ){
           rs.last();
           System.out.println("Number of rows: " + rs.getRow());
       }
    }
}
    
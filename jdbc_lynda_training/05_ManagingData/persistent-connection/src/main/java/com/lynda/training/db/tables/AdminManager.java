package com.lynda.training.db.tables;

import com.lynda.training.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by juan.hernandez on 2/22/18.
 */
public class AdminManager {
    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() throws SQLException{
        String sql = "SELECT adminId, userName, password from Admin";
        try(
                Statement stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );

                ResultSet rs = stmt.executeQuery(sql);
                ){

            System.out.println("Admin table: ");

            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append(rs.getInt("adminId"));
                bf.append("\n");
                bf.append(rs.getString("userName"));
                bf.append("\n");
                bf.append(rs.getString("password"));
                System.out.println(bf.toString());
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}

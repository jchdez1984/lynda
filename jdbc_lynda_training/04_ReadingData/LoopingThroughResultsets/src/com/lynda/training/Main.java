package com.lynda.training;

import com.lynda.training.com.lynda.training.db.DBType;
import com.lynda.training.com.lynda.training.db.DBUtil;
import com.lynda.training.db.tables.Tours;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String SQL = "select * from tours";

    public static void main(String[] args) throws SQLException {
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(SQL);
                )
        {
            Tours.displayData(rs);
        } catch (SQLException e){}
    }
}

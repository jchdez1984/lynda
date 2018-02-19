package com.lynda.training;


import com.lynda.training.db.DBType;
import com.lynda.training.db.DBUtil;
import com.lynda.training.db.tables.Tours;
import com.lynda.training.util.InputHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static final String SQL =
            "SELECT tourId, tourName, price FROM tours WHERE price <= ?";

    public static void main(String[] args) throws SQLException {
        double maxPrice;

        try {
            maxPrice = InputHelper.getDoubleInput("Enter maximum price: ");
        } catch (NumberFormatException e) {
            System.err.println("Error: invalid number");
            return;
        }

        ResultSet rs = null;

        try (
                Connection connection = DBUtil.getConnection(DBType.MYSLQ);
                PreparedStatement stmt = connection.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            stmt.setDouble(1, maxPrice);
            rs = stmt.executeQuery();
            Tours.displayData(rs);
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }
}

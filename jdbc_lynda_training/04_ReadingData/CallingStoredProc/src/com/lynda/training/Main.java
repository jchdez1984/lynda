package com.lynda.training;


import com.lynda.training.db.DBType;
import com.lynda.training.db.DBUtil;
import com.lynda.training.db.tables.Tours;
import com.lynda.training.util.InputHelper;
import jdk.internal.util.xml.impl.Input;

import java.sql.*;

public class Main {
    private static final String SQL = "{call GetToursWithCountByPrice(?, ?)}";

    public static void main(String[] args) throws SQLException {
        double maxPrice;

        try {
            maxPrice = InputHelper.getDoubleInput("Enter the max price: ");
        } catch (NumberFormatException e) {
            System.err.println(e);
            return;
        }

        ResultSet rs = null;

        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement stmt = conn.prepareCall(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            stmt.setDouble(1, maxPrice);
            stmt.registerOutParameter("total", Types.INTEGER);
            rs = stmt.executeQuery();

            int nRows = stmt.getInt("total");
            Tours.displayData(rs, nRows);
        } catch (SQLException e) {
            DBUtil.processException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }
}

package com.lynda.training;

import com.lynda.training.com.lynda.training.db.DBType;
import com.lynda.training.com.lynda.training.db.DBUtil;
import com.lynda.training.com.lynda.training.db.com.lynda.training.db.tables.States;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.sql.*;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT stateId, stateName FROM states");
        ) {
            States.displayData(rs);

            rs.last();
            System.out.println("Number of rows: " + rs.getRow());
            System.out.println("The last state is : " + rs.getString("stateName"));
            rs.first();
            System.out.println("The first state is : " + rs.getString("stateName"));

        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }
}

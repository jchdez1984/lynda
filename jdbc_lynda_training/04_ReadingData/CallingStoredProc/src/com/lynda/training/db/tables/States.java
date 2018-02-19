package com.lynda.training.db.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/19/18.
 */
public class States {
    public static void displayData(ResultSet rs) throws SQLException{
        while (rs.next()){
            String stateFullName =
                    rs.getString("stateId") + ": " + rs.getString("stateName");
            System.out.println(stateFullName);
        }
    }
}

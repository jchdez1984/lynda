package com.lynda.training.db.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by juan.hernandez on 2/19/18.
 */
public class Tours {
    public static void displayData(ResultSet rs) throws SQLException{
        rs.last();
        int nRows = rs.getRow();
        if(nRows == 0){
            System.out.println("No records found...");
        }
        else{
            System.out.println("Number of rows: " + nRows);
            rs.beforeFirst();

            while(rs.next()){
                StringBuffer buffer = new StringBuffer();
                buffer.append("Tour: " + rs.getInt("tourId") + ": ");
                buffer.append(rs.getString("tourName"));

                double price = rs.getDouble("price");
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
                String formattedPrice = nf.format(price);

                buffer.append(" (" + formattedPrice + ") ");
                System.out.println(buffer.toString());
            }
        }
    }
}

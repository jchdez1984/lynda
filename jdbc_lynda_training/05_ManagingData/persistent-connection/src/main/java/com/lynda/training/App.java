package com.lynda.training;

import com.lynda.training.db.tables.AdminManager;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        System.out.println( "Starting application..." );

        AdminManager.displayAllRows();
    }
}

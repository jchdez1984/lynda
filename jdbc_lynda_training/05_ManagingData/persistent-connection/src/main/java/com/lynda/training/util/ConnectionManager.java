package com.lynda.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by juan.hernandez on 2/20/18.
 */
public class ConnectionManager {
    private static ConnectionManager instance = null;

    private final String USERNAME = "dbuser";
    private final String PASSWORD = "dbpassword";
    private final String M_CONN_STRING = "jdbc:mysql://localhost:3306/explorecalifornia";
    private DBType dbType = DBType.MYSQL;
    private Connection conn = null;


    private ConnectionManager(){

    }

    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }
        return instance;
    }

    public boolean openConnection() {
        try {
            switch (dbType) {

                case MYSQL:
                    conn = DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
                    return true;
                default:
                    return false;

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public Connection getConnection(){
        if(conn == null){
            if(openConnection()){
                System.out.println("Connection opened...");
                return conn;
            } else {
                return null;
            }
        }
        return conn;
    }

    public void close(){
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}


package com.inonusosyal.api.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection connector=null;

    private DBConnection() {
    }

    synchronized public static DBConnection getInstance(){
        if (instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String password = "1234";
            String user = "postgres";
            String url = "jdbc:postgresql://localhost/inonusosyal";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public Connection getConnector() {
        if (this.connector == null) {
            this.connector = connect();
        }
        return this.connector;
    }
}

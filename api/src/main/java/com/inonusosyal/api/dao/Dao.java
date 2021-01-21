package com.inonusosyal.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private Connection conn;


    public Dao() {
    }

    public Connection getConn() {
        if (this.conn == null) {
                try {
                    Class.forName("org.postgresql.Driver");
                    String password = "1234";
                    String user = "postgres";
                    String url = "jdbc:postgresql://localhost/inonusosyal";
                    this.conn = DriverManager.getConnection(url, user, password);
                    System.out.println("Connected to the PostgreSQL server successfully.");
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        return this.conn;
    }

}

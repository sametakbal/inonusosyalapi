package com.inonusosyal.api.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {
    private Connection conn;
    private DBConnection db;


    public Dao() {
    }

    public Connection getConn() {
        if (this.conn == null) {
            this.conn = getDb().connect();
        }
        return this.conn;
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return this.db;
    }

}

package com.inonusosyal.api.dao;
import com.inonusosyal.api.dao.util.DBConnection;

import java.sql.Connection;

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

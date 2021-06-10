package com.example.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KVTRepository {
    private DatabaseConnection conn;

    public KVTRepository() {
        this.conn = new DatabaseConnection();
    }

    public boolean checkKeyExists(int key) {
        return true;
    }
}

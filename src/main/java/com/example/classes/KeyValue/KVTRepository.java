package com.example.classes.KeyValue;

import com.example.classes.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KVTRepository {
    private DatabaseConnection db;

    public KVTRepository() {
        this.db = new DatabaseConnection();
    }

    public boolean checkKeyExists(int key) {
        boolean c = false;
        try {
            ResultSet rs = db.st.executeQuery("select 1 [rs] from KeyValueTable where k = " + String.valueOf(key));
            if (rs.next())
                c = rs.getInt("rs") == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    public String getValue(int key) {
        String s = null;
        try {
            ResultSet rs = db.st.executeQuery("select top(1) v [rs] from KeyValueTable where k = " + String.valueOf(key));
            if (rs.next())
                s = rs.getString("rs");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return s;
    }
}

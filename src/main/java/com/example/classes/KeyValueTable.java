package com.example.classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KeyValueTable {
    public int key;
    public String value;

    public KeyValueTable(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.st.execute(
                    "use ekzbase" +
                            "create table KeyValueTable(key int, value varchar(50))"
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

package com.example.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {
    public Properties prop;
    public Connection conn;
    public Statement st;

    public DatabaseConnection() {
        conn = null;
        try {
            this.prop = new Properties();
            this.prop.load(new FileReader("src/main/resources/config.properties"));

            Class.forName(prop.getProperty("MS_JDBC_DRIVER")).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(prop.getProperty("MS_DB_URL"), prop.getProperty("MS_USER_NAME"), prop.getProperty("MS_PASSWORD"));

            st = conn.createStatement();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package classes;

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
    public static String MS_DB_URL = "jdbc:sqlserver://localhost:1433;database=ekzbase";
    public static String MS_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String MS_PASSWORD = "ewqqwe";
    public static String MS_USER_NAME = "Anton";

    public Connection conn;
    public Statement st;

    public DatabaseConnection() {
        conn = null;
        try {
            Class.forName(MS_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(MS_DB_URL,MS_USER_NAME,MS_PASSWORD);

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
        }
    }
}

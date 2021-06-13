package classes;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            ResultSet rs = db.st.executeQuery("select top(1) v [rs] from classes.KeyValueTable where k = " + String.valueOf(key));
            if (rs.next())
                s = rs.getString("rs");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return s;
    }

    public ArrayList<KeyValueTable> getValues(int count) {
        ArrayList<KeyValueTable> rsArr = new ArrayList<>();
        try {
            ResultSet rs = db.st.executeQuery("select top(" + count + ") k [key], v [value]  from KeyValueTable");
            while (rs.next())
                rsArr.add(new KeyValueTable(rs.getInt("key"), rs.getString("value")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsArr;
    }

    public void addRow(KeyValueTable el){
        Gson jsonParser = new Gson();
        try {
            db.st.execute(
                    "insert into KeyValueTable(k, v, serialized)\n" +
                            "values(" + el.key + ",  '" + el.value +"', '" + jsonParser.toJson(el) + "')"
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

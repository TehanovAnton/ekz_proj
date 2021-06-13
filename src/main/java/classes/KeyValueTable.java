package classes;

import java.io.Serializable;

public class KeyValueTable implements Serializable {
    public int key;
    public String value;

    public void setKey(int key) {
        this.key = key;
    }

    public KeyValueTable(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public KeyValueTable() {
    }

    public static void main(String[] args) {
        KVTRepository rep = new KVTRepository();
        rep.checkKeyExists(1);
        rep.getValue(1);
    }
}

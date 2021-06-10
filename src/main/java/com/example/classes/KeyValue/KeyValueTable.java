package com.example.classes.KeyValue;

public class KeyValueTable {
    public int key;
    public String value;

    public KeyValueTable(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        KVTRepository rep = new KVTRepository();
        rep.checkKeyExists(1);
        rep.getValue(1);
    }
}

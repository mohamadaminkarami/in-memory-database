package main.java.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Database {
    private static HashMap<String, Database> allDatabases = new HashMap<>();

    private HashMap<String, String> data;
    private String name;

    private String pipe;

    private Database(String name) {
        this.name = name;
        this.data = new HashMap<>();
        Database.allDatabases.put(name, this);
    }

    public void setData(String key, String value) {
        this.data.put(key, value);
    }

    public String getData(String key) {
        return this.data.get(key);
    }

    public void deleteData(String key) {
        this.data.remove(key);
    }

    public ArrayList<String> getKeys(String regex) {
        // return (ArrayList<String>) this.data.keySet().stream().filter(key ->
        // key.matches(regex))
        // .collect(Collectors.toList());

        ArrayList<String> keys = new ArrayList<>();
        for (String key : this.data.keySet()) {
            if (key.matches(regex)) {
                keys.add(key);
            }
        }
        return keys;

    }

    public static ArrayList<String> getDatabaseNames() {
        // return (ArrayList<String>) Database.allDatabases.keySet().stream()
        // .collect(Collectors.toList());

        ArrayList<String> databaseNames = new ArrayList<>();
        for (String databaseName : Database.allDatabases.keySet()) {
            databaseNames.add(databaseName);
        }
        return databaseNames;
    }

    public static Database getDatabase(String databaseName) {
        Database database = Database.allDatabases.get(databaseName);

        if (database != null) {
            return database;
        }
        return new Database(databaseName);
    }

    public void setPipe(String value) {
        this.pipe = value;
    }

    public String getPipeKey() {
        return this.pipe;
    }

    public String getPipeValue() {
        return this.data.get(this.getPipeKey());
    }

}
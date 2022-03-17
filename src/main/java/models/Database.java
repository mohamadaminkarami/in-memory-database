package main.java.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Database {
    private static HashMap<String, Database> allDatabases = new HashMap<>();

    private HashMap<String, String> data;
    private String name;

    public Database(String name) {
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
        return (ArrayList<String>) this.data.keySet().stream().filter(key -> key.matches(regex))
                .collect(Collectors.toList());
    }

    public static ArrayList<String> getDatabaseNames() {
        return (ArrayList<String>) Database.allDatabases.keySet().stream()
                .collect(Collectors.toList());
    }

    public Database getDatabase(String databaseName) {
        Database database = Database.allDatabases.get(databaseName);

        if (database != null) {
            return database;
        }
        return new Database(databaseName);
    }

}
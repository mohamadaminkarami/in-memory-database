package main.java.controllers;

import main.java.models.Database;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class DatabaseController {
    private Database database;

    public DatabaseController(Database database) {
        this.setDatabase(database);
    }

    private void setDatabase(Database database) {
        this.database = database;
    }

    public void set(Matcher matcher) {
        String key = matcher.group("key");
        String value = matcher.group("value");
        this.database.setData(key, value);
    }

    public String get(Matcher matcher) {
        String key = matcher.group("key");
        // String value = key.equals("$") ? this.database.getPipeValue() : this.database.getData(key);
        // or
        String value;
        if (key.equals("$")) {
            value = this.database.getPipeValue();
        } else {
            value = this.database.getData(key);
        }
        boolean hasPipeLine = matcher.group("pipe").trim().equals("|");

        if (hasPipeLine) {
            this.database.setPipe(value);
        }
        return value;

    }

    public void delete(Matcher matcher) {
        String key = matcher.group("key");
        this.database.deleteData(key);
    }

    public ArrayList<String> keys(Matcher matcher) {
        String regex = matcher.group("regex");
        return this.database.getKeys(regex);
    }

    public ArrayList<String> list() {
        return Database.getDatabaseNames();
    }

    public void use(Matcher matcher) {
        String databaseName = matcher.group("databaseName");
        Database newDatabase = Database.getDatabase(databaseName);
        this.setDatabase(newDatabase);
    }

}

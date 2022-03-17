package main.java.controllers;

import main.java.models.Database;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class DatabaseController {
    private Database database;

    public DatabaseController(Database database) {
        this.database = database;
    }

    public void set(Matcher matcher) {
        String key = matcher.group("key");
        String value = matcher.group("value");
        this.database.setData(key, value);
    }

    public String get(Matcher matcher) {
        String key = matcher.group("key");
        return this.database.getData(key);

    }

    public void delete(Matcher matcher) {
        String key = matcher.group("key");
        this.database.deleteData(key);
    }

    public ArrayList<String> keys(Matcher matcher) {
        String regex = matcher.group("regex");
        return this.database.getKeys(regex);
    }

    public ArrayList<String> getDatabaseNames() {
        return Database.getDatabaseNames();
    }

    public void use(Matcher matcher) {
        String databaseName = matcher.group("databaseName");
        this.database = this.database.getDatabase(databaseName);
    }


}

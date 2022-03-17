package main.java.controllers;

import main.java.models.Database;
import java.util.regex.Matcher;

public class DatabaseController {
    public Database database;

    public DatabaseController(Database database) {
        this.database = database;
    }

    public void set(Matcher matcher) {
        String key = matcher.group("key");
        String value = matcher.group("value");
        this.database.data.put(key, value);

    }

    public String get(Matcher matcher) {
        String key = matcher.group("key");
        return this.database.data.get(key);

    }

    public void delete(Matcher matcher) {
        String key = matcher.group("key");
        this.database.data.remove(key);
    }

}

package main.java.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Database {
    private HashMap<String, String> data;

    public Database() {
        this.data = new HashMap<>();
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

}
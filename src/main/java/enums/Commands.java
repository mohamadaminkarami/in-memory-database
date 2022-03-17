package main.java.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    SET("^SET (?<key>\\S+) (?<value>\\S+)$"),
    GET("^GET (?<key>\\S+)(?<pipe>( \\|)?)$"), // using pipeline
    DELETE("^DEL (?<key>\\S+)$"),
    USE("^USE (?<databaseName>\\S+)$"),
    LIST("^LIST$"),
    KEYS("^KEYS (?<regex>\\S+)$");

    private String regex;

    Commands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, Commands command) {
        Matcher matcher = Pattern.compile(command.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        // return matcher.matches() ? matcher : null;
       
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }

}

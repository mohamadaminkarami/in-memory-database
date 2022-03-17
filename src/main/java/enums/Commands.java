package main.java.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    SET("^SET (?<key>\\S+) (?<value>\\S+)$"),
    GET("^GET (?<key>\\S+)$"),
    DELETE("DEL (?<key>\\S+)$");

    public String regex;

    Commands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, Commands command) {
        Matcher matcher = Pattern.compile(command.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }

}

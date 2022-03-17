package main.java.views;

import main.java.controllers.DatabaseController;
import main.java.enums.Commands;
import java.util.Scanner;
import java.util.regex.Matcher;

public class CommandProcessor {
    public DatabaseController databaseController;

    public CommandProcessor(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    public void run() {
        String input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Matcher matcher;
            input = scanner.nextLine();
            if (input.equals("EXIT")) {
                scanner.close();
                break;
            }
            if ((matcher = Commands.getMatcher(input, Commands.GET)) != null) {
                System.out.println(this.databaseController.get(matcher));
            } else if ((matcher = Commands.getMatcher(input, Commands.SET)) != null) {
                this.databaseController.set(matcher);

            } else if ((matcher = Commands.getMatcher(input, Commands.DELETE)) != null) {
                this.databaseController.delete(matcher);
            } else {
                System.out.println("INVALID COMMAND");
            }
        }

    }
}

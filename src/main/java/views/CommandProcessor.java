package main.java.views;

import main.java.controllers.DatabaseController;
import main.java.enums.Commands;
import java.util.Scanner;
import java.util.regex.Matcher;

public class CommandProcessor {
    private DatabaseController databaseController;

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
            } else if ((matcher = Commands.getMatcher(input, Commands.KEYS)) != null) {
                System.out.println(this.databaseController.keys(matcher));
            } else if ((matcher = Commands.getMatcher(input, Commands.USE)) != null) {
                this.databaseController.use(matcher);
            } else if ((matcher = Commands.getMatcher(input, Commands.LIST)) != null) {
                System.out.println(this.databaseController.list());
            } else {
                System.out.println("INVALID COMMAND");
            }
        }

    }
}

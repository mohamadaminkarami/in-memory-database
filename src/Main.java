import main.java.controllers.DatabaseController;
import main.java.models.Database;
import main.java.views.CommandProcessor;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getDatabase("default");
        DatabaseController databaseController = new DatabaseController(database);
        CommandProcessor commandProcessor = new CommandProcessor(databaseController);
        commandProcessor.run();
    }
}

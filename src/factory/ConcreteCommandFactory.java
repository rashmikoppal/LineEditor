package factory;

import commands.*;
import document.Document;

public class ConcreteCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String commandName, Document document) {
        switch (commandName) {
            case "list":
                return new ListCommand(document);
            case "del":
                return new DeleteCommand(document);
            case "ins":
                return new InsertCommand(document);
            case "save":
                return new SaveCommand(document);
            case "quit":
                return new QuitCommand();
            default:
                throw new IllegalArgumentException("Unknown command: " + commandName);
        }
    }
}

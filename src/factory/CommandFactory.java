package factory;

import commands.Command;
import document.Document;

public interface CommandFactory {
    Command createCommand(String commandName, Document document);
}

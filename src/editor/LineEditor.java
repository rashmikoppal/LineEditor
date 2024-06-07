package editor;

import commands.Command;
import document.Document;
import factory.CommandFactory;
import factory.ConcreteCommandFactory;

import java.io.IOException;
import java.util.Scanner;

public class LineEditor {
    private CommandFactory commandFactory;
    private Document document;

    public LineEditor(CommandFactory commandFactory, Document document) {
        this.commandFactory = commandFactory;
        this.document = document;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String commandLine;

        while (true) {
            System.out.print(">> ");
            commandLine = scanner.nextLine();
            String[] commandParts = commandLine.split(" ", 3);

            try {
                Command command = commandFactory.createCommand(commandParts[0], document);
                command.execute(commandParts);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: lineeditor <file_path>");
            return;
        }

        try {
            Document document = new Document(args[0]);
            CommandFactory commandFactory = new ConcreteCommandFactory();
            LineEditor editor = new LineEditor(commandFactory, document);
            editor.run();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

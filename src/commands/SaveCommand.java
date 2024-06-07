package commands;

import document.Document;

import java.io.IOException;

public class SaveCommand implements Command {
    private Document document;

    public SaveCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute(String[] args) {
        try {
            document.save();
            System.out.println("File saved.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}

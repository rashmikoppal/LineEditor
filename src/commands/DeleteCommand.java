package commands;

import document.Document;

public class DeleteCommand implements Command {
    private Document document;

    public DeleteCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            try {
                int lineNumber = Integer.parseInt(args[1]);
                document.delete(lineNumber);
            } catch (NumberFormatException e) {
                System.out.println("Invalid line number.");
            }
        } else {
            System.out.println("Usage: del <line_number>");
        }
    }
}

package commands;

import document.Document;

public class InsertCommand implements Command {
    private Document document;

    public InsertCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 3) {
            try {
                int lineNumber = Integer.parseInt(args[1]);
                document.insert(lineNumber, args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid line number.");
            }
        } else {
            System.out.println("Usage: ins <line_number> <text>");
        }
    }
}

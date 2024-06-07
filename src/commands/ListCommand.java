package commands;

import document.Document;

public class ListCommand implements Command{
    private Document document;

    public ListCommand(Document document) {
        this.document = document;
    }
    @Override
    public void execute(String[] args) {
        document.list();
    }
}

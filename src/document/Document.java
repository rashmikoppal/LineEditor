package document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<String> lines;
    private String filePath;

    public Document(String filePath) throws IOException {
        this.filePath = filePath;
        this.lines = new ArrayList<>();
        loadFile();
    }

    private void loadFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
    }

    public void list() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }

    public void delete(int lineNumber) {
        if (lineNumber < 1 || lineNumber > lines.size()) {
            System.out.println("Invalid line number.");
        } else {
            lines.remove(lineNumber - 1);
        }
    }

    public void insert(int lineNumber, String lineContent) {
        if (lineNumber < 1 || lineNumber > lines.size() + 1) {
            System.out.println("Invalid line number.");
        } else {
            lines.add(lineNumber - 1, lineContent);
        }
    }

    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}

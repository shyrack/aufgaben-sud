package sud.aufgaben.occupationalTherapy.pricing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelBufferedReader {

    private static final String COMMA_DELIMITER = ";";

    private Path file;
    private final List<String[]> records;

    public ExcelBufferedReader(String filename) {
        this.file = Paths.get(filename);
        this.records = new ArrayList<>();
    }

    public List<String[]> getRecords() {
        return this.records;
    }

    public Path getFile() {
        return this.file;
    }

    public int getTemperatureInLine(int lineNumber) {
        return Integer.parseInt(records.get(lineNumber)[1]);
    }

    public void printData() {
        for (String[] stringList : this.records) {
            for (String s : stringList)
                System.out.print(s + "; ");
            System.out.println();
        }
    }

    public void readFile() throws IOException {
        this.records.clear();
        List<String> lines = Files.readAllLines(file);
        for (String line : lines) {
            if (line != null) {
                this.records.add(line.split(COMMA_DELIMITER));
            }
        }
    }

    public void setFile(Path file) {
        this.file = file;
    }

}

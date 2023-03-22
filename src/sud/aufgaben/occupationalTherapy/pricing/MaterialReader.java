package sud.aufgaben.occupationalTherapy.pricing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaterialReader {

    private static final String COMMA_DELIMITER = ";";

    private Path file;
    private final Map<String, Material> records;

    public MaterialReader(String filename) {
        this.file = Paths.get(filename);
        this.records = new HashMap<>();
    }

    public Material getRecord(String key) {
        return this.records.get(key);
    }

    public Map<String, Material> getRecords() {
        return this.records;
    }

    public Path getFile() {
        return this.file;
    }

    public void printData() {
        this.records.forEach((key, material) -> {
            System.out.println(key + ": " + material.getPrice());
        });
    }

    public Map<String, Material> readFile() throws IOException {
        this.records.clear();
        List<String> lines = Files.readAllLines(file);
        for (String line : lines) {
            if (line != null) {
                String[] lineValues = line.split(COMMA_DELIMITER);
                if (lineValues.length == 2) {
                    this.records.put(lineValues[0], new Material(lineValues[0], Double.parseDouble(lineValues[1])));
                } else {
                    throw new IOException("File read was not valid.");
                }
            }
        }
        return this.records;
    }

    public void setFile(Path file) {
        this.file = file;
    }

}

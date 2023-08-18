package sud.aufgaben.occupationalTherapy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter<T extends CSVWritable> extends BufferedWriter {
    private static String defaultPath = "src/sud/aufgaben/occupationalTherapy/out/";

    public CsvWriter(String path) throws IOException {
        super(new FileWriter(new File(defaultPath + path)));
    }

    public void write(T t) throws IOException {
        super.write(t.toCSV() + "\n");
        super.flush();
    }
}
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import occupationalTherapy.CSVWritable;

public class CSVWriter<T extends CSVWritable> extends BufferedWriter {

    public CSVWriter(File file) throws IOException {
        super(new FileWriter(file));
    }

    public void writeT(T t) throws IOException {
        super.write(t.toCSV() + "\n");
        super.flush();
    }

}

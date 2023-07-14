package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    private final String filePath;
    private final String fileName;

    public FileWriter(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public void appendToFile(List<String> toAppend) throws IOException {
        File resultFile = new File(filePath + fileName);
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(resultFile, true));

        for (String element : toAppend) {
            try {
                writer.append(element);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        writer.close();
    }
}

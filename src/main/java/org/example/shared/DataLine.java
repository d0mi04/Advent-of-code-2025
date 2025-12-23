package org.example.shared;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataLine {
    private final ArrayList<String> lines;

    public DataLine(String filename, String itemSeparator) {
        this.lines = ReadLines(filename, itemSeparator);
    }

    public ArrayList<String> ReadLines(String filename, String itemSeparator) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] longLine = br.readLine().split(itemSeparator);
            lines.addAll(Arrays.asList(longLine));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public ArrayList<String> getLines() {
        return this.lines;
    }
}

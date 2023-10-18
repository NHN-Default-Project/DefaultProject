package com.nhnacademy.gaeun.exercise6;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private final String inputFilePath;

    private ReadFile(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public static ReadFile of(String inputFilePath) {
        return new ReadFile(inputFilePath);
    }
    public static ReadFile ofSelectFile(Frame frame) throws FileNotFoundException {
        FileDialog fileDialog = new FileDialog(frame, "Select Input File", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String inputFilePath = fileDialog.getDirectory() + fileDialog.getFile();
        if (fileDialog.getFile() == null) {
            throw new FileNotFoundException("No output file selected. Exiting.");
        }
        return new ReadFile(inputFilePath);
    }

    public List<String> readLines() { //read
        List<String> readLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                readLines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return readLines;
    }

}

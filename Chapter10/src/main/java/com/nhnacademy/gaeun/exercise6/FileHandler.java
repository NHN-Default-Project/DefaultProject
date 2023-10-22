package com.nhnacademy.gaeun.exercise6;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileHandler {
    private final String filePath;

    private FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public static FileHandler from(String filePath) {
        return new FileHandler(filePath);
    }

    public static FileHandler fromSelectFile(Frame frame) throws FileNotFoundException {
        FileDialog fileDialog = new FileDialog(frame);
        fileDialog.setVisible(true);
        String filePath = fileDialog.getDirectory() + fileDialog.getFile();
        if (fileDialog.getFile() == null) {
            throw new FileNotFoundException("No file selected. Exiting.");
        }
        return new FileHandler(filePath);
    }

    public List<String> readLines() {
        List<String> readLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                readLines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return readLines;
    }

    public void writeFile(Map<String, List<Integer>> mapData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath))) {
            for (Map.Entry<String, List<Integer>> entry : mapData.entrySet()) {
                writer.write(entry.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.nhnacademy.gaeun.exercise6;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteFile {
    private final String outputFilePath;

    private WriteFile(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public static WriteFile of(String outputFilePath) {
        return new WriteFile(outputFilePath);
    }
    public static WriteFile ofSelectFile(Frame frame) throws FileNotFoundException {
        FileDialog fileDialog = new FileDialog(frame, "Select Input File", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String outputFilePath = fileDialog.getDirectory() + fileDialog.getFile();
        if (fileDialog.getFile() == null) {
            throw new FileNotFoundException("No output file selected. Exiting.");
        }
        return new WriteFile(outputFilePath);
    }

    public void writeFile(Map<String, List<Integer>> mapData) { //write
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.outputFilePath))) {
            for (Map.Entry<String, List<Integer>> entry : mapData.entrySet()) {
                writer.write(entry.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

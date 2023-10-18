package com.nhnacademy.jaehyeon.exercise10_6;

import java.awt.*;
import java.io.FileNotFoundException;

public class FileSelector {
    private final Frame frame;

    public FileSelector() {
        this.frame = new Frame();
    }

    public String selectReadFile() {
        FileDialog fileDialog;
        try {
            fileDialog = new FileDialog(this.frame, "SelectInputFile", FileDialog.LOAD);
            fileDialog.setVisible(true);
            return getFilepath(fileDialog);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String selectWriteFile() {
        FileDialog fileDialog;
        try {
            fileDialog = new FileDialog(this.frame, "Select Output File", FileDialog.SAVE);
            fileDialog.setVisible(true);
            return getFilepath(fileDialog);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String getFilepath(FileDialog fileDialog) throws FileNotFoundException {
        String selectFilePath = fileDialog.getDirectory() + fileDialog.getFile();
        if (fileDialog.getFile() == null) {
            throw new FileNotFoundException("파일이 없다");
        }

        return selectFilePath;
    }

}

package com.nhnacademy.main.exercise7_6;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadReadFile();
        DataManipulator.sortListByAlphabetical(DataManipulator.removeDuplicateChar(fileHandler.getWordsList()));
        fileHandler.loadWriteFile();
    }
}
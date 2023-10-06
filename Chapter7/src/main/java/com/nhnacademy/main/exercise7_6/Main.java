package com.nhnacademy.main.exercise7_6;

public class Main {
    /*
     * https://math.hws.edu/javanotes/c7/exercises.html
     * Write a program that will read a text file selected by the user
     * Will make an alphabetical list of all the different words in that file
     * All words should be converted to lower case
     * Duplicates should be eliminated from the list
     * The list should be written to an output file selected by the user
     */
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadReadFile();
        DataManipulator.sortListByAlphabetical(DataManipulator.removeDuplicateChar(fileHandler.getWordsList()));
        fileHandler.loadWriteFile();
    }
}
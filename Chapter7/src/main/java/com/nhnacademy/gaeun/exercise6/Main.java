package com.nhnacademy.gaeun.exercise6;

/*
 * https://math.hws.edu/javanotes/c7/exercises.html
 * Write a program that will read a text file selected by the user
 * Will make an alphabetical list of all the different words in that file
 * All words should be converted to lower case
 * Duplicates should be eliminated from the list
 * The list should be written to an output file selected by the user
 */
public class Main {
    public static void main(String[] args) {
        String userFile = "/Users/kaeun/DefaultProject/Chapter7/src/main/java/com/nhnacademy/gaeun/exercise6/userFile.txt";
        String outputFile = "/Users/kaeun/DefaultProject/Chapter7/src/main/java/com/nhnacademy/gaeun/exercise6/outputFile.txt";
        FileReadAndWrite fileRead = new FileReadAndWrite(userFile, outputFile);
        fileRead.readAndWrite();
    }
}

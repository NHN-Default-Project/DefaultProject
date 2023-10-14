package com.nhnacademy.gaeun.exercise2;

import java.util.List;
import java.util.Scanner;
/*
 * https://math.hws.edu/javanotes/c9/exercises.html
 * Write a new version of the same program
 * that stores the words in a binary sort tree instead of in an arraylist.
 */
public class Exercise9_2 {
    public static void main(String[] args) {
        String path = "/Users/kaeun/DefaultProject/Chapter9/src/main/java/com/nhnacademy/gaeun/exercise2/readFIle.txt";
        String writePath = "/Users/kaeun/DefaultProject/Chapter9/src/main/java/com/nhnacademy/gaeun/exercise2/writeFile.txt";
        FileRead fileRead = new FileRead(path);
        WordTree wordTree = fileRead.load();
        FileWrite fileWrite = new FileWrite(writePath);
        fileWrite.writeToFile(wordTree);
    }
}

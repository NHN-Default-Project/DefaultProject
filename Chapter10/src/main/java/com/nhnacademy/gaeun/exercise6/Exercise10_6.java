package com.nhnacademy.gaeun.exercise6;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise10_6 {
    public static void main(String[] args) {
        readUserSelectedFile();
        System.exit(0);
    }

    private static void readUserSelectedFile() {
        try {
            Frame frame = new Frame();
            FileHandler readFile = FileHandler.fromSelectFile(frame);
            FileHandler writeFile = FileHandler.fromSelectFile(frame);

            Concordance wordList = new Concordance();
            StringConvertor stringConvertor = new StringConvertor();
            stringConvertor.convertToWordMap(readFile.readLines());
//            stringConvertor.sortWordMap();
            wordList.initialSetting(stringConvertor.getWordToMap());
            writeFile.writeFile(wordList.getConcordance());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


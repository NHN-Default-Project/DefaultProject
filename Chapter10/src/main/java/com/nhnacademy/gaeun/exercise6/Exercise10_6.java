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
            ReadFile readFile = ReadFile.ofSelectFile(frame);
            WriteFile writeFile = WriteFile.ofSelectFile(frame);

            Concordance wordList = new Concordance();
            wordList.initialSetting(StringConvertor.get().convertToWordMap(readFile.readLines()));
            writeFile.writeFile(wordList.getConcordance());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


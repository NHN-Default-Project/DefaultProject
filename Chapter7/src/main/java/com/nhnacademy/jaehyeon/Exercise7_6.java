package com.nhnacademy.jaehyeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise7_6 {

    public static void main(String[] args) {
        TextIO.readFile("/Users/hyeon/Desktop/default_project/JaeHyeon/chapter7/test.txt");
        List<String> stringList = new ArrayList<>();

        while (!TextIO.eof()) {
            String str = readNextWord();
            if (str != null) {
                stringList.add(str);
            }
        }

        List<String> a = stringList.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted().collect(Collectors.toList());

        for (String str : a) {
            System.out.println(str);
        }
    }


    private static String readNextWord() {
        char ch = TextIO.peek();
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {

            TextIO.getAnyChar();
            ch = TextIO.peek();
        }
        if (ch == TextIO.EOF) {
            return null;
        }

        String word = "";
        while (true) {
            word += TextIO.getAnyChar();
            ch = TextIO.peek();
            if (ch == '\'') {
                TextIO.getAnyChar();
                ch = TextIO.peek();
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();
                } else {
                    break;
                }
            }
            if (!Character.isLetter(ch)) {

                break;
            }

        }
        return word;
    }


}



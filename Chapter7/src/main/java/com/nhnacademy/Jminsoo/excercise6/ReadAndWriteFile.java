package com.nhnacademy.Jminsoo.excercise6;

import com.nhnacademy.Jminsoo.excercise6.textio.TextIO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReadAndWriteFile {
    private List<String> list;


    public ReadAndWriteFile(String path) {
        this.list = new ArrayList<>();
        insertFileToList(path);
    }

    public void print() {
        this.list.forEach(System.out::println);
        System.out.println();
    }

    public void removeDuplicates() {
        this.list = list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public void write() {

        TextIO.writeUserSelectedFile();
        for (String str : this.list) {
            TextIO.putln(str);
        }
        TextIO.writeStandardOutput();
//
//        TextIO.writeFile("convertFile.txt");
    }


    public void toLowerCaseList() {
        this.list = list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public void toUpperCaseList() {
        this.list = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }


    public void sort(boolean isDesc) {
        if (isDesc) {
            this.list = list.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

        } else {
            this.list = list.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }
    }


    private void insertFileToList(String path) {
        TextIO.readFile(path);

        while (!TextIO.eof()) {
            String temp = ReadAndWriteFile.readNextWord();
            if (temp == null) {
                break;
            }
            this.list.add(temp);
        }
    }


    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            // Skip past non-letters.
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();   // Look at the next character.
        }
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
        // At this point, we know the next character is a letter, so read a word.
        String word = "";  // This will be the word that is read.
        while (true) {
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek();  // Look at next character.
            if (ch == '\'') {
                // The next character is an apostrophe.  Read it, and
                // if the following character is a letter, add both the
                // apostrophe and the letter onto the word and continue
                // reading the word.  If the character after the apostrophe
                // is not a letter, the word is done, so break out of the loop.
                TextIO.getAnyChar();   // Read the apostrophe.
                ch = TextIO.peek();    // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                } else
                    break;
            }
            if (!Character.isLetter(ch)) {
                // If the next character is not a letter, the word is
                // finished, so break out of the loop.
                break;
            }
            // If we haven't broken out of the loop, next char is a letter.
        }
        return word;  // Return the word that has been read.
    }


}

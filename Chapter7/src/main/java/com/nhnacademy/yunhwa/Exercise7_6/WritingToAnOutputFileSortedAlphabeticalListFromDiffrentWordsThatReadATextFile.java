package com.nhnacademy.yunhwa.Exercise7_6;

import java.util.*;

public class WritingToAnOutputFileSortedAlphabeticalListFromDiffrentWordsThatReadATextFile {

    private ArrayList<String> wordsList;

    public WritingToAnOutputFileSortedAlphabeticalListFromDiffrentWordsThatReadATextFile() {
        this.wordsList = new ArrayList<>();
    }

    public void printList() {
        System.out.println("-------------------------------");
        for (String word : wordsList) {
            System.out.println(word);
        }
        System.out.println("-------------------------------");
    }
    public void sortListByAlphabetical() {
        Collections.sort(wordsList);
    }

    public void readUserSelectedFile() {
        TextIO.readUserSelectedFile();
        String word = "";
        while (! TextIO.eof()) {
            word = readNextWord();
            if (word != null) {
                this.wordsList.add(word.toLowerCase());
            }
        }
        Set<String> strSet = Set.copyOf(wordsList);
        this.wordsList = new ArrayList<>(strSet);
    }

    public void writeUserSelectedFile() {
        TextIO.writeUserSelectedFile();
        for (int i = 0; i < this.wordsList.size(); i++) {
            TextIO.putln(this.wordsList.get(i));
        }
    }

    public void readTextFile(String path) {
        TextIO.readFile(path);
        String word = "";
        while (! TextIO.eof()) {
            word = readNextWord();
            if (word != null) {
                this.wordsList.add(word.toLowerCase());
            }
        }
        Set<String> strSet = Set.copyOf(wordsList);
        this.wordsList = new ArrayList<>(strSet);
    }

    public void writeTextFile(String path) {
        TextIO.writeFile(path);
        for (int i = 0; i < this.wordsList.size(); i++) {
            TextIO.putln(this.wordsList.get(i));
        }
    }

    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
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
            if ( ch == '\'' ) {
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
                }
                else
                    break;
            }
            if ( ! Character.isLetter(ch) ) {
                // If the next character is not a letter, the word is
                // finished, so break out of the loop.
                break;
            }
            // If we haven't broken out of the loop, next char is a letter.
        }
        return word;  // Return the word that has been read.
    }
}
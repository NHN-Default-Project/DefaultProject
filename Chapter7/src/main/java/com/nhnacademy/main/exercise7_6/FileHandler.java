package com.nhnacademy.main.exercise7_6;

import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private List<String> wordsList;


    public FileHandler() {
        this.wordsList = new ArrayList<>();
    }

    public void loadReadFile() {
        readUserSelectedFile();
        this.wordsList = makeWordsList(this.wordsList);
    }

    public void readUserSelectedFile() {
        TextIO.readUserSelectedFile();
    }


    // 위 2개에서 사용되는 내부 메서드
    public List<String> makeWordsList(List<String> wordsList) {
        String word = "";
        while (!TextIO.eof()) {
            word = readNextWord();
            if (word != null) {
                wordsList.add(word.toLowerCase());
            }
        }
        return wordsList;
    }

    public void loadWriteFile() {
        TextIO.writeUserSelectedFile();
        this.wordsList = receiveData(this.wordsList);
    }

    public List<String> receiveData(List<String> wordsList) {
        for (String string : wordsList) {
            TextIO.putln(string);
        }
        return wordsList;
    }


    private String readNextWord() {
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

    public List<String> getWordsList() {
        return wordsList;
    }
}
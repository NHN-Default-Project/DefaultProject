package com.nhnacademy.main.exercise2;

import com.nhnacademy.main.exercise2.textio.TextIO;

import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileByTree {
    private BinaryTree<String> tree;


    public ReadAndWriteFileByTree() {
        this.tree = new BinaryTree<>();
        TextIO.readUserSelectedFile();
        insertFileToTree();
    }

    public void print() {
        tree.printTree();
    }

    public void writeToFile() {
        try {
            TextIO.writeUserSelectedFile();
            List<String> strList = new ArrayList<>();
            tree.inorder(strList);
            for (String str : strList) {
                TextIO.putln(str);
            }
            TextIO.writeStandardOutput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    private void insertFileToTree() {

        while (!TextIO.eof()) {
            String temp = ReadAndWriteFileByTree.readNextWord();
            if (temp == null) {
                break;
            }
            temp = temp.toLowerCase();

            if (tree.treeContains(temp)) {
                System.out.println("\nThat item is already in the tree.");
            } else {
                tree.insert(temp);  // Add user's string to the tree.
            }
        }
    }


    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();   // Look at the next character.
        }
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
        String word = "";  // This will be the word that is read.
        while (true) {
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek();  // Look at next character.
            if (ch == '\'') {
                TextIO.getAnyChar();   // Read the apostrophe.
                ch = TextIO.peek();    // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                } else
                    break;
            }
            if (!Character.isLetter(ch)) {
                break;
            }
        }
        return word;  // Return the word that has been read.
    }


}

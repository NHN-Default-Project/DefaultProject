package com.nhnacademy.Jminsoo.exercise2;

import com.nhnacademy.Jminsoo.exercise2.textio.TextIO;

import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileByTree {
    private BinaryTree tree;


    public ReadAndWriteFileByTree(String path) {
        this.tree = new BinaryTree();
        insertFileToTree(path);
    }

    public void print() {
        tree.treeList(BinaryTree.root);
    }

    public void write() {

        try {
            TextIO.writeUserSelectedFile();
            List<String> strList = new ArrayList<>();
            tree.inOrder(BinaryTree.root, strList);
            for (String str : strList) {
                TextIO.putln(str);
            }
            TextIO.writeStandardOutput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    private void insertFileToTree(String path) {
        TextIO.readFile(path);

        while (!TextIO.eof()) {
            String temp = ReadAndWriteFileByTree.readNextWord();
            if (temp == null) {
                break;
            }
            temp = temp.toLowerCase();

            if (tree.treeContains(BinaryTree.root, temp)) {
                System.out.println("\nThat item is already in the tree.");
            } else {
                tree.insert(temp);  // Add user's string to the tree.
            }
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

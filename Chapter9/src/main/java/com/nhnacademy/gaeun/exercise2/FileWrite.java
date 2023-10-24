package com.nhnacademy.gaeun.exercise2;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    private final String path;

    public FileWrite(String path) {
        this.path = path;
    }

    public void writeToFile(WordTree wordTree) {
        try (FileWriter fileWriter = new FileWriter(path, true)){
            writeNodeToFile(wordTree.getRoot(), fileWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeNodeToFile(WordTree.TreeNode node, FileWriter fileWriter) throws IOException {
        if (node != null) {
            writeNodeToFile(node.left, fileWriter);
            fileWriter.write(node.item);
            fileWriter.write("\n");// Print item in the node.
            writeNodeToFile(node.right, fileWriter);            // Print items in the right subtree.
        }
    }
}

package com.nhnacademy.gaeun.exercise2;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    private final String path;
    private WordTree wordTree;

    public FileWrite(String path) {
        this.path = path;
        wordTree = new WordTree();
    }

    public void writeToFile(WordTree wordTree) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            treeList(wordTree.getRoot(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void treeList(TreeNode node, FileWriter fileWriter) throws IOException {
        if (node != null) {
            treeList(node.left, fileWriter);
            fileWriter.write(node.item);
            fileWriter.write("\n");// Print item in the node.
            treeList(node.right, fileWriter);            // Print items in the right subtree.
        }
    }
}

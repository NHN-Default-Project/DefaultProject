package com.nhnacademy.Jminsoo.exercise4;

public class Exercise9_4 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.treeInsert("abc");
        tree.treeInsert("aabc");
        tree.treeInsert("abbc");
        tree.treeInsert("abcc");
        tree.treeInsert("dabcc");
        tree.treeInsert("aaaaa");


        tree.printTree();
    }
}

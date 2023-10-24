package com.nhnacademy.yunhwa.exercise9_2;

public class Exercise9_2 {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();

        ReadFile.readUserSelectedFile();
        binarySortTree.storedStringsInBinarySortTree();

        WriteFile.writeUserSelectedFile();
        binarySortTree.writeBinarySortTree(binarySortTree.getRoot());
        binarySortTree.printBinarySortTreeByRecursion();
    }
}
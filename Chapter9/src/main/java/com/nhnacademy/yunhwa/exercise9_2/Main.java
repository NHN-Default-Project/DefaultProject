package com.nhnacademy.yunhwa.exercise9_2;

public class Main {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        ReadFile.readUserSelectedFile();
        BinarySortTree.storedStringsInBinarySortTree();
        WriteFile.writeUserSelectedFile();
        BinarySortTree.writeBinarySortTree(binarySortTree.getRoot());
        BinarySortTree.printBinarySortTreeByRecursion();
    }
}
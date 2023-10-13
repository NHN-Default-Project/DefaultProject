package com.nhnacademy.Jminsoo.exercise5;

import java.util.Random;

public class Exercise9_5 {
    static final int COUNT = 1_024;

    public static void main(String[] args) {

        BinaryTree<Double> binaryTree = new BinaryTree<>();


        try {
            for (int i = 0; i < COUNT; i++) {
                binaryTree.insert(randomInsert());
            }
            System.out.println("평균 깊이 : " + binaryTree.getTreeAverageDepth());
            System.out.println("가장 깊은 깊이 : " + binaryTree.getMaxDepth());
            binaryTree.printLeafNode();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static double randomInsert() {
        Random random = new Random();
        return random.nextDouble() * 1000.0;
    }

}

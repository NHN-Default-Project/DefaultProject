package com.nhnacademy.gaeun.exercise5;
/*
 * https://math.hws.edu/javanotes/c9/exercises.html
 * you can create the tree by generating 1023 random real numbers and inserting them into the tree,
 * using the usual treeInsert() method for binary sort trees.
 * you should compute and output the average depth of all the leaves in the tree
 * and the maximum depth of all the leaves
 *
 * subroutines:
 * one to count the leaves,
 * one to find the sum of the depths of all the leaves,
 * and one to find the maximum depth.
 */
public class Exercise9_5 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.treeInsert();
        binaryTree.printStatus();
    }
}

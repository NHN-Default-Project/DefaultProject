package com.nhnacademy.main;

/*
 * https://math.hws.edu/javanotes/c9/exercises.html
 * Write a subroutine that implements this algorithm,
 * and write a program to test the subroutine.
 * Note that you will need a queue of TreeNodes,
 * so you will need to write a class to represent such queues.
 */
public class Exercise9_4 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.treeInsert("apple");
        tree.treeInsert("banana");
        tree.treeInsert("cherry");
        tree.treeInsert("apple");
        tree.treeInsert("strawberry");
        tree.treeInsert("pineapple");
        tree.treeInsert("grapes");
        tree.treeInsert("lemon");


        System.out.println();
        tree.printTree();
    }
}

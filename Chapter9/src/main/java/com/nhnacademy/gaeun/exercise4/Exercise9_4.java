package com.nhnacademy.gaeun.exercise4;


import java.util.*;

import com.nhnacademy.gaeun.exercise4.BinaryTree;
/*
 * https://math.hws.edu/javanotes/c9/exercises.html
 * Write a subroutine that implements this algorithm,
 * and write a program to test the subroutine.
 * Note that you will need a queue of TreeNodes,
 * so you will need to write a class to represent such queues.
 */

public class Exercise9_4 {

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.treeInsert("5");
        binaryTree.treeInsert("3");
        binaryTree.treeInsert("7");
        binaryTree.treeInsert("10");

        binaryTree.printQueue(queue);


    }
}

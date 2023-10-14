package com.nhnacademy.gaeun.exercise4;


import java.util.*;

import com.nhnacademy.gaeun.exercise4.BinaryTree;

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

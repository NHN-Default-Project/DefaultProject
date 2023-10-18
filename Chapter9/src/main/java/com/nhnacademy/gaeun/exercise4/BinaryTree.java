package com.nhnacademy.gaeun.exercise4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;
    private TreeNode left;
    private TreeNode right;


    public BinaryTree() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public void treeInsert(String newItem) {
        if (root == null) {
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if (newItem.compareTo(runner.item) == 0) {
                return;
            }
            if (newItem.compareTo(runner.item) < 0) {
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;
                } else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;
                } else
                    runner = runner.right;
            }
        }
    }

    public void printQueue(Queue<TreeNode> queue) {
        queue.add(this.root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.item);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

}

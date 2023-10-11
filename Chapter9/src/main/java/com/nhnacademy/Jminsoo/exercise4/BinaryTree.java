package com.nhnacademy.Jminsoo.exercise4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private static class BinaryTreeNode<T extends Comparable<T>> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;


        BinaryTreeNode(T value) {
            this.value = value;
        }

    }

    private BinaryTreeNode<T> root;

    public void treeInsert(T newItem) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(newItem);
            return;
        }
        BinaryTreeNode<T> runner;
        runner = this.root;
        while (true) {
            if (newItem.compareTo(runner.value) < 0) {
                if (runner.left == null) {
                    runner.left = new BinaryTreeNode<>(newItem);
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new BinaryTreeNode<>(newItem);
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }
    }


    private T inOrder(BinaryTreeNode<T> node, Queue<T> nodeQueue) {
        if (this.root == null) {
            throw new IllegalArgumentException("트리가 비어있습니다!");
        }
        if (node.left != null) {
            nodeQueue.add(inOrder(node.left, nodeQueue));
        }
        if (node.right != null) {
            nodeQueue.add(inOrder(node.right, nodeQueue));
        }
        return node.value;
    }

    public void printTree() {
        Queue<T> nodeQueue = new LinkedList<>();
        inOrder(this.root, nodeQueue);
        nodeQueue.forEach(System.out::println);
    }
}

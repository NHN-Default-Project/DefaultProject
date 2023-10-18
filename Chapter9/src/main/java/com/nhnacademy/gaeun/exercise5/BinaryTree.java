package com.nhnacademy.gaeun.exercise5;

import java.util.Random;

public class BinaryTree {
    private Node root;
    private final int SIZE = 1023;
    private int sum;
    private int countNode;
    private int maxDepth;

    public BinaryTree() {
        this.root = null;
        this.sum = 0;
        this.countNode = 0;
        this.maxDepth = 0;
    }

    public void printStatus() {
        System.out.println();
        printAvgDepth();
        printMaxDepth();
    }
    public void printAvgDepth() {
        sumLeafNodeDepth(root, 0);
        calLeafNodeCount(root);
        System.out.println("모든 잎의 평균 깊이: " + sum / countNode);
    }

    public void printMaxDepth() {
        calMaxDepth(root, 0);
        System.out.println("모든 잎의 최대 깊이: " + maxDepth);
    }

    public void treeInsert() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            add(random.nextDouble() * 1024);
        }
    }

    public void add(double value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            root = addNode(root, newNode);
        }
    }

    public  Node addNode(Node node, Node newNode) {
        if (node == null) {
            return newNode;
        }
        if (node.compareTo(newNode) > 0) {
            node.left = addNode(node.left, newNode);
        } else if (node.compareTo(newNode) < 0) {
            node.right = addNode(node.right, newNode);
        }
        return node;
    }


    public int calLeafNodeCount(Node node) { //노드 총 개수
        countNode++;
        if (node.left != null) {
            calLeafNodeCount(node.left);
        }
        if (node.right != null) {
            calLeafNodeCount(node.right);
        }
        return countNode;
    }

    public int sumLeafNodeDepth(Node node, int depth) { //노드 깊이의 합
        if (node.left != null) {
            sumLeafNodeDepth(node.left, depth + 1);
        }
        System.out.println(node.value);
        if (node.right != null) {
            sumLeafNodeDepth(node.right, depth + 1);
        }
        sum += depth;
        return depth;
    }

    public int calMaxDepth(Node node, int depth) { //최대 깊이 계산
        if (node.left == null && node.right == null) {
            if (maxDepth < depth) {
                maxDepth = depth;
            }
        }
        if (node.left != null) {
            calMaxDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            calMaxDepth(node.right, depth + 1);
        }
        return depth;
    }
}

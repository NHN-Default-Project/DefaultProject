package com.nhnacademy.gaeun.exercise5;

import java.util.Random;

public class BinaryTree<T extends Comparable> {
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }
    private Node<T> root;
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


    public void add(double value) {
        Node<T> newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            root = addNode(root, newNode);
        }
    }

    private  Node<T> addNode(Node<T> node, Node<T> newNode) {
        if (node == null) {
            return newNode;
        }
        if (node.value.compareTo(newNode.value) > 0) {
            node.left = addNode(node.left, newNode);
        } else if (node.value.compareTo(newNode.value) < 0) {
            node.right = addNode(node.right, newNode);
        }
        return node;
    }


    private void calLeafNodeCount(Node<T> node) { //노드 총 개수
        this.countNode++;
        if (node.left != null) {
            calLeafNodeCount(node.left);
        }
        if (node.right != null) {
            calLeafNodeCount(node.right);
        }
    }

    private void sumLeafNodeDepth(Node<T> node, int depth) { //노드 깊이의 합
        if (node.left != null) {
            sumLeafNodeDepth(node.left, depth + 1);
        }
        System.out.println(node.value);
        if (node.right != null) {
            sumLeafNodeDepth(node.right, depth + 1);
        }
        sum += depth;
    }

    private void calMaxDepth(Node<T> node, int depth) { //최대 깊이 계산
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
    }
}

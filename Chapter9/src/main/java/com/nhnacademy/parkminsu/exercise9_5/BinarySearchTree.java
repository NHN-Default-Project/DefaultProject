package com.nhnacademy.parkminsu.exercise9_5;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;
    private int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root = addNode(this.root, newNode);
        }
        size++;

    }

    private Node<T> addNode(Node<T> node, Node<T> newNode) {
        if (node == null) {
            node = newNode;
        }
        if (node.data.compareTo(newNode.data) > 0) {
            node.left = addNode(node.left, newNode);

        } else if (node.data.compareTo(newNode.data) < 0) {
            node.right = addNode(node.right, newNode);
        }
        return node;
    }


    public List<Integer> findLeafNodeDepths() { // 이진트리 높이를
        List<Integer> depthList = new ArrayList<>();
        if (this.root == null) {
            throw new IllegalArgumentException("해당 노드는 Null입니다.");
        }
        return findLeafNodeDepths(depthList, this.root, 0); //
    }

    //
    private List<Integer> findLeafNodeDepths(List<Integer> depthList, Node<T> node, int depth1) {// 가장 왼쪽에 있는 리프노드
        int depth = depth1;
        if (node.left == null && node.right == null) {
            depthList.add(depth);
            return depthList;
        }
        depth += 1;
        if (node.left != null) {
            depthList = findLeafNodeDepths(depthList, node.left, depth);
        }
        if (node.right != null) {
            depthList = findLeafNodeDepths(depthList, node.right, depth);
        }
        return depthList;
    }

    public int maxDepthOfLeafNodes() { // 가장 깊은 depth 값
        return findLeafNodeDepths().stream()
                .mapToInt(Integer::intValue).max().orElse(0);
    }


    public int countDepthOfLeafNodes() {
        return findLeafNodeDepths().size();
    }


    public void printAscendingOrder() {
        leftInorderTraversal(this.root);
    }

    public void printDescendingOrder() {
        rightInorderTraversal(this.root);
    }

    public void printPreorder() {
        preorderTraversal(this.root);
    }

    public void preorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    private void rightInorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        rightInorderTraversal(node.right);
        System.out.println(node.data);
        rightInorderTraversal(node.left);
    }

    private void leftInorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        leftInorderTraversal(node.left);
        System.out.println(node.data);
        leftInorderTraversal(node.right);
    }

    public int size() {
        return this.size;
    }

    private static class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;


        public Node(T data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", data=" + data +
                    '}';
        }
    }
}

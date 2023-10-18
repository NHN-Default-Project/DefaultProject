package com.nhnacademy.parkminsu.exercise9_4;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySortTree {
    private Node root;


    private int size = 0;

    public void add(String data) {
        Node newNode = new Node(data);

        this.root = addNode(this.root, newNode);

        size++;

    }

    private Node addNode(Node node, Node newNode) {
        if (node == null) {
            return newNode;

        } else if (node.getData().compareTo(newNode.getData()) > 0) {

            node.left = addNode(node.left, newNode);
        } else if (node.getData().compareTo(newNode.getData()) < 0) {
            node.right = addNode(node.right, newNode);
        }

        return node; // 중복일 시 본인의 node를 반환
    }


    public String search(String data) {
        return searchNode(this.root, data).getData();
    }

    private Node searchNode(Node node, String data) {
        if (node == null) {
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");
        }
        if (node.getData().compareTo(data) < 0) {
            return searchNode(node.left, data);
        } else if (node.getData().compareTo(data) > 0) {
            return searchNode(node.right, data);
        } else {
            return node;
        }
    }

    public void ascendingTraversal() {
        leftInorderTraversal(this.root);
    }

    private void leftInorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        leftInorderTraversal(node.left);
        System.out.println(node.getData());
        leftInorderTraversal(node.right);
    }

    public void descendingTraversal() {
        System.out.println("내림 차순 순회");
        rightInorderTraversal(this.root);
        System.out.println();
    }

    private void rightInorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        rightInorderTraversal(node.right);
        System.out.println(node.getData());
        rightInorderTraversal(node.left);

    }

    public void print() {
        inputDataToQueue(this.root);
    }

    private void inputDataToQueue(Node nodes) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes); // Node의 toString에서 조건문으로 처리함
        if (queue.isEmpty()) {
            throw new NullPointerException("노드에 값이 없습니다");
        }
        System.out.println(queue.poll());
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "" + root + "\n";
    }

    static class Node {

        Node left;
        Node right;
        private String data;

        public Node(String data) {
            this.data = data;
        }


        public String getData() {
            return data;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.left != null) {
                stringBuilder.append(this.left);
            }
            stringBuilder.append(getData() + " ");
            if (this.right != null) {
                stringBuilder.append(this.right);
            }
            return stringBuilder.toString();

        }

    }


}

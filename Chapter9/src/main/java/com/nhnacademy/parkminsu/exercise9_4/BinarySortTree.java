package com.nhnacademy.parkminsu.exercise9_4;

public class BinarySortTree {
    private Node root;


    private int size = 0;

    public void add(String data) {
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root = addNode(this.root, newNode);
        }
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


    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "" + root + "\n";
    }

    public Node getRoot() {
        return root;
    }


}

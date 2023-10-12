package com.nhnacademy.jaehyeon.exercise9_5;

public class TreeNode {
    private Node root;
    int maxDepth;
    int count;

    public void insert(double value) {
        this.root = insertNode(this.root, value);
    }

    public Node insertNode(Node root, double value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (root.value > value) {
            root.left = insertNode(root.left, value);
        } else if (root.value < value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public int getMaxDepth() {
        return goDepth(this.root);
    }

    private int goDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = goDepth(node.left);
            int right = goDepth(node.right);
            return Math.max(left, right) + 1;
        }
    }

    public int getTotalDepth() {
        if (root == null) {
            return 0;
        }
        return totalDepth(root, 0);
    }

    private int totalDepth(Node node, int depth) {
        if (node == null) {
            return 0;
        }
        int left = totalDepth(node.left, depth + 1);
        int right = totalDepth(node.right, depth + 1);

        return depth + left + right;
    }

    public int getTotalNode() {
        return totalNode(this.root);
    }

    private int totalNode(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return totalNode(node.left) + totalNode(node.right);
    }

    public double averageDepth() {
        int totalDepth = getTotalDepth();
        int totalNode = getTotalNode();
        return (double) totalDepth / totalNode;
    }


    public void writeTree() {
        writeTreeNode(this.root);
    }

    private void writeTreeNode(Node node) {
        if (node != null) {
            writeTreeNode(node.left);
            System.out.println(node.value);
            writeTreeNode(node.right);
        }
    }
}

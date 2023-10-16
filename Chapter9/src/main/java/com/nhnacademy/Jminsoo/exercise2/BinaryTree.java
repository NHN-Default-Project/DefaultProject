package com.nhnacademy.Jminsoo.exercise2;

import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;

    public void insert(T newItem) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(newItem);
            return;
        }
        BinaryTreeNode<T> runner;
        runner = root;
        while (true) {
            if (runner.value.equals(newItem)) {
                System.out.print(newItem + " ");
                System.out.println("동일한 값이 있습니다! 이를 제외합니다.");
                return;
            }

            if (newItem.compareTo(runner.value) < 0) {
                if (runner.left == null) {
                    runner.left = new BinaryTreeNode<>(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new BinaryTreeNode<>(newItem);
                    return;  // New item has been added to the tree.
                } else {
                    runner = runner.right;
                }
            }
        } // end while
    }  // end treeInsert()


    private boolean treeContains(BinaryTreeNode<T> root, T item) {
        if (root == null) {
            return false;
        } else if (item.equals(root.value)) {
            return true;
        } else if (item.compareTo(root.getValue()) < 0) {
            return treeContains(root.left, item);
        }
        return treeContains(root.right, item);
    }

    public boolean treeContains(T item) {
        return treeContains(this.root, item);
    }  // end treeContains()

    public void printTree() {
        printTreeList(this.root);
    }

    private void printTreeList(BinaryTreeNode<T> node) {
        if (node != null) {
            printTreeList(node.left);
            System.out.println("  " + node.value);
            printTreeList(node.right);
        }
    }

    public void inorder(List<T> nodeList) {
        this.inOrder(this.root, nodeList);
    }


    private T inOrder(BinaryTreeNode<T> node, List<T> nodeList) {
        if (root == null) {
            throw new IllegalArgumentException("트리가 비어있습니다!");
        }
        if (node.left != null) {
            nodeList.add(inOrder(node.left, nodeList));
        }
        if (node.right != null) {
            nodeList.add(inOrder(node.right, nodeList));
        }
        return node.value;

    }

    private static class BinaryTreeNode<T extends Comparable<T>> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }
    }

}

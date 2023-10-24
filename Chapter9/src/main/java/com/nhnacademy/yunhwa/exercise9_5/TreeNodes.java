package com.nhnacademy.yunhwa.exercise9_5;


import java.util.*;

public class TreeNodes<T extends Comparable<T>> {
    private static class TreeNode<T> {
        T item;
        TreeNode left;
        TreeNode right;

        TreeNode(T realNum) {
            item = realNum;
        }
    }

    List<Integer> depthList;

    public TreeNodes() {
        this.depthList = new ArrayList<>();
    }



    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }


    public void treeInsert(T newItem) {
        if (root == null) {

            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if ((newItem.compareTo((T) runner.item)) < 0) {

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

    public boolean treeContains(TreeNode root, T item) {
        if (root == null) {
            return false;
        } else if (item.equals(root.item)) {
            return true;
        } else if (item.compareTo((T) root.item) < 0) {
            return treeContains(root.left, item);
        } else {
            return treeContains(root.right, item);
        }
    }

    public void treeList(TreeNode node) {
        if (node != null) {
            treeList(node.left);
            System.out.println("  " + node.item);
            treeList(node.right);
        }
    }

    public void makeDepthListOfAllTheLeaves(TreeNode node, int count, int depth) {
        if (node != null) {
            if (node.left == null && node.right == null) { // 리프 노드일 때 추가
                this.depthList.add(depth);
            } else {
                makeDepthListOfAllTheLeaves(node.left, count + 1, depth + 1);
                makeDepthListOfAllTheLeaves(node.right, count + 1, depth + 1);
            }
        }
    }

    public int averageDepthOfAllTheLeaves() {
        int sum = 0;
        for (int depth : this.depthList) {
            sum += depth;
        }
        return sum / this.depthList.size();
    }

    public int maxDepthOfAllTheLeaves() {
        return Collections.max(this.depthList);
    }

    public void printTreeList(TreeNode node) {
        if (node != null) {
            printTreeList(node.left);
            System.out.println("  " + node.item);
            printTreeList(node.right);
        }
    }
}
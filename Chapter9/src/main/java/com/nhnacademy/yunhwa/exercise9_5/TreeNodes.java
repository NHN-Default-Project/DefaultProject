package com.nhnacademy.yunhwa.exercise9_5;

import com.nhnacademy.yunhwa.exercise9_2.SortTreeDemo;

import java.util.*;

public class TreeNodes {
    List<Integer> depthList;

    public TreeNodes() {
        this.depthList = new ArrayList<>();
    }

    private static class TreeNode {
        double item;      // The data in this node.
        TreeNode left;    // Pointer to left subtree.
        TreeNode right;   // Pointer to right subtree.

        TreeNode(double realNum) {
            // Constructor.  Make a node containing the specified string.
            // Note that left and right pointers are initially null.
            item = realNum;
        }
    }  // end nested class TreeNode

    private static TreeNode root;  // Pointer to the root node in a binary tree.
    // This tree is used in this program as a
    // binary sort tree.  When the tree is empty,
    // root is null (as it is initially).

    public TreeNode getRoot() {
        return root;
    }


    /**
     * Add the item to the binary sort tree to which the global variable
     * "root" refers.  (Note that root can't be passed as a parameter to
     * this routine because the value of root might change, and a change
     * in the value of a formal parameter does not change the actual parameter.)
     */
    public void treeInsert(double newItem) {
        if (root == null) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (newItem < runner.item) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner.  If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                // Since the new item is greater than or equal to the item in
                // runner it belongs in the right subtree of runner.  If there
                // is an open space at runner.right, add a new node there.
                // Otherwise, advance runner down one level to the right.
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.right;
            }
        } // end while
    }  // end treeInsert()

    /**
     * Return true if item is one of the items in the binary
     * sort tree to which root points.  Return false if not.
     */
    boolean treeContains(TreeNode root, double item) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        } else if (item == root.item) {
            // Yes, the item has been found in the root node.
            return true;
        } else if (item < root.item) {
            // If the item occurs, it must be in the left subtree.
            return treeContains(root.left, item);
        } else {
            // If the item occurs, it must be in the right subtree.
            return treeContains(root.right, item);
        }
    }  // end treeContains()


    /**
     * Print the items in the tree in inorder, one item to a line.
     * Since the tree is a sort tree, the output will be in increasing order.
     */
    public void treeList(TreeNode node) {
        if (node != null) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.item);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()

    public void makeDepthListOfAllTheLeaves(TreeNode node, int count, int depth) {
        if (node != null) {
            this.depthList.add(depth);
            makeDepthListOfAllTheLeaves(node.left, count++, depth + 1);
            makeDepthListOfAllTheLeaves(node.right, count++, depth + 1);
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
            printTreeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.item);  // Print item in the node.
            printTreeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()

}
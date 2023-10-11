package com.nhnacademy.Jminsoo.exercise2;

import java.util.List;

public class BinaryTree {
    private static class BinaryTreeNode {
        String value;
        BinaryTree.BinaryTreeNode left;
        BinaryTree.BinaryTreeNode right;


        BinaryTreeNode(String value) {
            this.value = value;
        }

    }

    static BinaryTreeNode root;  // Pointer to the root node in a binary tree.

    public void insert(String newItem) {
        if (root == null) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new BinaryTreeNode(newItem);
            return;
        }
        BinaryTreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (newItem.compareTo(runner.value) < 0) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner.  If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if (runner.left == null) {
                    runner.left = new BinaryTreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                // Since the new item is greater than or equal to the item in
                // runner it belongs in the right subtree of runner.  If there
                // is an open space at runner.right, add a new node there.
                // Otherwise, advance runner down one level to the right.
                if (runner.right == null) {
                    runner.right = new BinaryTreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else {
                    runner = runner.right;
                }
            }
        } // end while
    }  // end treeInsert()


    /**
     * Return true if item is one of the items in the binary
     * sort tree to which root points.  Return false if not.
     */
    public boolean treeContains(BinaryTreeNode root, String item) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        } else if (item.equals(root.value)) {
            // Yes, the item has been found in the root node.
            return true;
        } else if (item.compareTo(root.value) < 0) {
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
    public void treeList(BinaryTreeNode node) {
        if (node != null) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.value);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()

    private boolean isNodeInTree(BinaryTreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException("트리가 비어있습니다!");
        } else if (node.left == null) {
            return isNodeInTree(node.right);
        } else if (node.right == null) {
            return isNodeInTree(node.left);
        } else {
            return true;
        }
    }


    public String inOrder(BinaryTreeNode node, List<String> nodeList) {
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


    /**
     * Count the nodes in the binary tree.
     *
     * @param node A pointer to the root of the tree.  A null value indicates
     *             an empty tree.
     * @return the number of nodes in the tree to which node points.  For an
     * empty tree, the value is zero.
     */
    public int countNodes(BinaryTreeNode node) {
        if (node == null) {
            // Tree is empty, so it contains no nodes.
            return 0;
        } else {
            // Add up the root node and the nodes in its two subtrees.
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    } // end countNodes()
}

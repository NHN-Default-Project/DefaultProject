package com.nhnacademy.yunhwa.exercise9_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This program demonstrates a few routines for processing binary
 * sort trees.  It uses a binary sort tree of strings.  The user
 * types in strings.  The user's string is converted to lower case, and --
 * if it is not already in the tree -- it is inserted into the tree.
 * Then the number of nodes in the tree and a list of items in the tree
 * are output.  The program ends when the user enters an empty string.
 */
public class SortTreeDemo {

    /**
     * An object of type TreeNode represents one node in a binary tree of strings.
     */
    private static class TreeNode {
        String item;      // The data in this node.
        TreeNode left;    // Pointer to left subtree.
        TreeNode right;   // Pointer to right subtree.

        TreeNode(String str) {
            // Constructor.  Make a node containing the specified string.
            // Note that left and right pointers are initially null.
            item = str;
        }
    }  // end nested class TreeNode

    private static TreeNode root;  // Pointer to the root node in a binary tree.
    // This tree is used in this program as a
    // binary sort tree.  When the tree is empty,
    // root is null (as it is initially).



    private static void readUserSelectedFile() {
        TextIO.readUserSelectedFile();
    }

    public static void storedStringsInBinarySortTree() {
        TextIO.readUserSelectedFile();

        String word = "";
        while (! TextIO.eof()) {
            word = readNextWord();
            if (word != null && ! treeContains(root, word)) {
                treeInsert(word.toLowerCase());
            }
        }
    }

    private static void writeUserSelectedFile() {
        TextIO.writeUserSelectedFile();
    }

    public static void writeBinarySortTreeByUser() {
        TextIO.writeUserSelectedFile();
        writeBinarySortTree(root);
    }

    // 중위 순회 inOrder : Left -> Root -> Right
    public static void writeBinarySortTree(TreeNode node) {
        if (node != null) {
            if (node.left != null) writeBinarySortTree(node.left);             // Print items in left subtree.
            TextIO.putln(node.item);        // Print item in the node.
            if (node.right != null) writeBinarySortTree(node.right);          // Print items in the right subtree.
        }
    }



    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            // Skip past non-letters.
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();   // Look at the next character.
        }
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
        // At this point, we know the next character is a letter, so read a word.
        String word = "";  // This will be the word that is read.
        while (true) {
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek();  // Look at next character.
            if (ch == '\'') {
                // The next character is an apostrophe.  Read it, and
                // if the following character is a letter, add both the
                // apostrophe and the letter onto the word and continue
                // reading the word.  If the character after the apostrophe
                // is not a letter, the word is done, so break out of the loop.
                TextIO.getAnyChar();   // Read the apostrophe.
                ch = TextIO.peek();    // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                } else
                    break;
            }
            if (!Character.isLetter(ch)) {
                // If the next character is not a letter, the word is
                // finished, so break out of the loop.
                break;
            }
            // If we haven't broken out of the loop, next char is a letter.
        }
        return word;  // Return the word that has been read.
    }


    /**
     * Add the item to the binary sort tree to which the global variable
     * "root" refers.  (Note that root can't be passed as a parameter to
     * this routine because the value of root might change, and a change
     * in the value of a formal parameter does not change the actual parameter.)
     */
    private static void treeInsert(String newItem) {
        if (root == null) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
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
    static boolean treeContains(TreeNode root, String item) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        } else if (item.equals(root.item)) {
            // Yes, the item has been found in the root node.
            return true;
        } else if (item.compareTo(root.item) < 0) {
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
    private static void printTreeList(TreeNode node) {
        if (node != null) {
            printTreeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.item);  // Print item in the node.
            printTreeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()

    public static void printBinarySortTreeByRecursion() {
        System.out.println("\nThe tree contains " + countNodes(root) + " items.");
        System.out.println("\nContents of tree:\n");
        printTreeList(root);
    }

    // 9_4 번에서 활용되는 비재귀적 방식으로 이진트리 항목 인쇄하는 메서드 (큐 활용)
    public static void printBinartSortTreeUsingQueue() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println(" " + currentNode.item);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }


    /**
     * Count the nodes in the binary tree.
     *
     * @param node A pointer to the root of the tree.  A null value indicates
     *             an empty tree.
     * @return the number of nodes in the tree to which node points.  For an
     * empty tree, the value is zero.
     */
    private static int countNodes(TreeNode node) {
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


} // end class SortTreeDemo
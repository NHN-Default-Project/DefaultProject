package com.nhnacademy.gaeun.exercise2;

/**
 *  This program demonstrates a few routines for processing binary
 *  sort trees.  It uses a binary sort tree of strings.  The user
 *  types in strings.  The user's string is converted to lower case, and --
 *  if it is not already in the tree -- it is inserted into the tree.
 *  Then the number of nodes in the tree and a list of items in the tree
 *  are output.  The program ends when the user enters an empty string.
 */
public class WordTree {
    private static TreeNode root;
    public static TreeNode getRoot() {
        return root;
    }

    public static void treeInsert(String newItem) {
        if ( root == null ) {
            root = new TreeNode( newItem );
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if(newItem.compareTo(runner.item) == 0) {
                return;
            }
            if ( newItem.compareTo(runner.item) < 0 ) {
                if ( runner.left == null ) {
                    runner.left = new TreeNode( newItem );
                    return;
                }
                else
                    runner = runner.left;
            }
            else {
                if ( runner.right == null ) {
                    runner.right = new TreeNode( newItem );
                    return;
                }
                else
                    runner = runner.right;
            }
        }
    }
}
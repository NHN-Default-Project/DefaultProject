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
    protected static class TreeNode {
        protected String item;
        protected TreeNode left;
        protected TreeNode right;
        protected TreeNode(String str) {
            item = str;
        }
    }
    private TreeNode root;
    public TreeNode getRoot() {
        return root;
    }
}
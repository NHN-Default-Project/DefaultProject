package com.nhnacademy.gaeun.exercise4;

import com.nhnacademy.gaeun.exercise2.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise9_4 {
    private static Queue<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode("1");
        TreeNode treeNode2 = new TreeNode("2");
        TreeNode treeNode3 = new TreeNode("3");
        TreeNode treeNode4 = new TreeNode("4");
        TreeNode treeNode5 = new TreeNode("4");
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode1.left.left = treeNode4;

        printQueue(treeNode1);
    }

    public static void printQueue(TreeNode head) {
        queue.add(head);

        while(!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.item);
            if(treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if(treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }
}

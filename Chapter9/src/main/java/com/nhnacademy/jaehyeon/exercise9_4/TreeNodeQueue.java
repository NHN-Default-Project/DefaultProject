package com.nhnacademy.jaehyeon.exercise9_4;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeQueue {
    private final Queue<TreeNode> queue;

    public TreeNodeQueue() {
        this.queue = new LinkedList<>();
    }

    public void printNode(TreeNode root) {
        if (root == null) {
            return;
        }

        this.queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode nowNode = queue.poll();
            if (nowNode.left != null) {
                queue.add(nowNode.left);
            }
            if (nowNode.right != null) {
                queue.add(nowNode.right);
            }
            System.out.println(nowNode.value);

        }
    }
}

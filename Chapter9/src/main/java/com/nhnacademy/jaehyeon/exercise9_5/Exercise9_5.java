package com.nhnacademy.jaehyeon.exercise9_5;


import java.util.Random;

public class Exercise9_5 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            treeNode.insert(random.nextInt() * 20);
        }

        System.out.println("총 노드의 갯수 : " + treeNode.getTotalNode());
        System.out.println("총 노드의 깊이 : " + treeNode.calculateTotalNodeDepth());
        System.out.println("트리의 총 깊이 : " + treeNode.getMaxDepth());
        System.out.println("노드의 평균 깊이 : " + treeNode.calculateAverageDepth());

    }
}

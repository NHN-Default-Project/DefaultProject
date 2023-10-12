package com.nhnacademy.jaehyeon.exercise9_5;


import java.util.Random;

public class Exercise9_5 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        Random random = new Random();

        for (int i = 0; i < 1023; i++) {
            treeNode.insert(random.nextDouble() * 1023);
        }


        System.out.println("평균은 : " + treeNode.averageDepth());
        System.out.println("최대 깊이는 : " + treeNode.getMaxDepth());

    }
}

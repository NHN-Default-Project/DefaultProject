package com.nhnacademy.parkminsu.exercise9_5;

public class Exercise9_5 {
    /**
     * 1023개의 노드를 가진 무작위 이진 정렬트리 만들기
     * 타입은 실수
     * treeInsert() 메소드를 통해 이진 트리 생성
     * 만든 후 모든 리프의 평균 길이, 모든 리프 중 가장 큰 깊이
     * 깊이를 나타내는 depth 매개변수 가져야함
     * 호출 시 0 재귀적 호출시 카운트 1
     */

    public static void main(String[] args) {
        BinarySearchTree<Double> binarySearchTree = new BinarySearchTree<>();
        int loopBreak = 1023;
        while (binarySearchTree.size() < loopBreak) {
            binarySearchTree.insert(Math.random() * 100 + 1);
        }
        System.out.println("전위 순회");
        binarySearchTree.printPreorder();
        System.out.println("\n오름 차순");
        binarySearchTree.printAscendingOrder();
        System.out.println("\n내림 차순");
        binarySearchTree.printDescendingOrder();
        System.out.println("Leaf Node: " + binarySearchTree.findLeafNodeDepths());
        System.out.println("Leaf Node중 가장 깊은 depth: " + binarySearchTree.maxDepthOfLeafNodes());
        System.out.println("Leaf Node의 갯수: " + binarySearchTree.countDepthOfLeafNodes());
        System.out.println(binarySearchTree.size());

    }

}

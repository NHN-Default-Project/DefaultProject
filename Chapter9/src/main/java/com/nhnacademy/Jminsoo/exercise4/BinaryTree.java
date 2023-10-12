package com.nhnacademy.Jminsoo.exercise4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BinaryTree 클래스는 제네릭 타입 T를 사용하여 비교 가능한 항목들을 저장하는 이진 트리를 생성하고 관리합니다.
 *
 * @param <T> 이진 트리에 저장되는 항목의 타입
 */
public class BinaryTree<T extends Comparable<T>> {
    /**
     * BinaryTreeNode은 이진 트리의 노드를 나타내며, 제네릭 타입 T로 값들을 저장합니다.
     *
     * @param <T> 노드가 저장하는 값의 타입
     */
    private static class BinaryTreeNode<T extends Comparable<T>> {
        T value;           // 이 노드에 저장된 값
        BinaryTreeNode<T> left;   // 왼쪽 자식 노드
        BinaryTreeNode<T> right;  // 오른쪽 자식 노드

        /**
         * BinaryTreeNode 객체를 생성하고 주어진 값으로 초기화합니다.
         *
         * @param value 노드가 저장할 값
         */
        BinaryTreeNode(T value) {
            this.value = value;
        }
    }

    private BinaryTreeNode<T> root;  // 이진 트리의 루트 노드

    /**
     * 주어진 값을 이진 트리에 삽입하는 메서드입니다.
     *
     * @param newItem 삽입할 값
     */
    public void treeInsert(T newItem) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(newItem); // 루트 노드를 새로 생성하고 값을 저장
            return;
        }
        BinaryTreeNode<T> runner;
        runner = this.root;
        while (true) {
            if (newItem.compareTo(runner.value) < 0) {
                if (runner.left == null) {
                    runner.left = new BinaryTreeNode<>(newItem); // 왼쪽 자식 노드를 새로 생성하고 값을 저장
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new BinaryTreeNode<>(newItem); // 오른쪽 자식 노드를 새로 생성하고 값을 저장
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }
    }

    /**
     * 이진 트리의 노드를 중위 순회하여 큐에 추가하고 값을 반환합니다.
     *
     * @param node      현재 노드
     * @param nodeQueue 큐에 노드 값을 추가하기 위한 큐
     * @return 현재 노드의 값
     */
    private T inOrder(BinaryTreeNode<T> node, Queue<T> nodeQueue) {
        if (this.root == null) {
            throw new IllegalArgumentException("트리가 비어있습니다!");
        }
        if (node.left != null) {
            nodeQueue.add(inOrder(node.left, nodeQueue)); // 왼쪽 자식 노드 순회
        }
        if (node.right != null) {
            nodeQueue.add(inOrder(node.right, nodeQueue)); // 오른쪽 자식 노드 순회
        }
        return node.value;
    }

    /**
     * 트리의 노드를 중위 순회하여 출력하는 메서드입니다.
     */
    public void printTree() {
        Queue<T> nodeQueue = new LinkedList<>();
        inOrder(this.root, nodeQueue); // 중위 순회 시작
        nodeQueue.forEach(System.out::println); // 결과 출력
    }
}

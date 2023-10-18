package com.nhnacademy.main.exercise9_5;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree<T extends Comparable<T>> {
    private static class BinaryTreeNode<T extends Comparable<T>> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;


        BinaryTreeNode(T value) {
            this.value = value;
        }

    }

    private BinaryTreeNode<T> root;

    public void insert(T inputValue) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(inputValue);
            return;
        }
        BinaryTreeNode<T> runner = root;
        while (true) {
            if (runner.value.equals(inputValue)) {
                System.out.print(inputValue + " ");
                System.out.println("동일한 값이 있습니다! 이를 제외합니다.");
                return;
            }
            if (runner.value.compareTo(inputValue) < 0) {
                if (runner.left == null) {
                    runner.left = new BinaryTreeNode<>(inputValue);
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new BinaryTreeNode<>(inputValue);
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }
    }


    private Map<BinaryTreeNode<T>, Long> getMapOfLeafNode(BinaryTreeNode<T> node, Map<BinaryTreeNode<T>, Long> leafNodeMap, long depth) {

        if (this.root == null) {
            throw new IllegalArgumentException("트리가 비어있습니다.");
        }
        if (node.left != null) {
            getMapOfLeafNode(node.left, leafNodeMap, depth++);
        }
        if (node.right != null) {
            getMapOfLeafNode(node.right, leafNodeMap, depth++);
        }
        if (node.left == null && node.right == null) {
            leafNodeMap.put(node, depth);
        }
        return leafNodeMap;
    }

    public long getMaxDepth() {
        Map<BinaryTreeNode<T>, Long> resultMap = this.getMapOfLeafNode(this.root, new HashMap<>(), 0);
        return resultMap.keySet()
                .stream()
                .map(resultMap::get)
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L);
    }

    public double getTreeAverageDepth() {
        Map<BinaryTreeNode<T>, Long> resultMap = this.getMapOfLeafNode(this.root, new HashMap<>(), 0);

        return resultMap.keySet()
                .stream()
                .map(resultMap::get)
                .mapToLong(Long::longValue)
                .average().orElse(0);
    }

    public Long getTreeLeafCount() {
        Map<BinaryTreeNode<T>, Long> resultMap = this.getMapOfLeafNode(this.root, new HashMap<>(), 0);
        long count = resultMap.size();
        return count;
    }

    public void printLeafNode() {
        Map<BinaryTreeNode<T>, Long> resultMap = this.getMapOfLeafNode(this.root, new HashMap<>(), 0);
        resultMap.keySet()
                .stream()
                .map(resultMap::get)
                .forEach(x -> System.out.print(x + " "));
    }

}

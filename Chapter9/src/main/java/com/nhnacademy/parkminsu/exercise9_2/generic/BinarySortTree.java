package com.nhnacademy.parkminsu.exercise9_2.generic;

public class BinarySortTree<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        this.root = addNode(this.root, newNode);
    }

    private Node<T> addNode(Node<T> node, Node<T> newNode) {
        if (node == null) {
            return newNode;
        } else if (node.data.compareTo(newNode.data) > 0) {
            node.left = addNode(node.left, newNode);
        } else if (node.data.compareTo(newNode.data) < 0) {
            node.right = addNode(node.right, newNode);
        }
        return node; // 중복일 시 본인의 node를 반환
    }


    public T search(T data) {
        return searchNode(this.root, data).data;
    }

    private Node<T> searchNode(Node node, T data) {
        if (node == null) {
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");
        }
        if (node.data.compareTo(data) < 0) {
            return searchNode(node.left, data);
        } else if (node.data.compareTo(data) > 0) {
            return searchNode(node.right, data);
        } else {
            return node;
        }
    }

    public void ascendingTraversal() {
        leftInorderTraversal(this.root);
    }

    private void leftInorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        leftInorderTraversal(node.left);
        System.out.println(node.data);
        leftInorderTraversal(node.right);
    }

    public void descendingTraversal() {
        System.out.println("내림 차순 순회");
        rightInorderTraversal(this.root);
        System.out.println();
    }

    public void rightInorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        rightInorderTraversal(node.right);
        System.out.println(node.data);
        rightInorderTraversal(node.left);

    }

    @Override
    public String toString() {
        return "" + root + "\n";
    }

    private static class Node<T extends Comparable<T>> {

        Node<T> left;
        Node<T> right;
        private final T data;

        public Node(T data) {
            this.data = data;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.left != null) {
                stringBuilder.append(this.left);
            }
            stringBuilder.append(this.data).append("\n");
            if (this.right != null) {
                stringBuilder.append(this.right);
            }
            return stringBuilder.toString();

        }

    }


}

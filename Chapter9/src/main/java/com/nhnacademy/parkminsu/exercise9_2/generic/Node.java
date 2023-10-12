package com.nhnacademy.parkminsu.exercise9_2.generic;

public class Node<T extends Comparable<T>> {

    Node<T> left;
    Node<T> right;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.left != null) {
            stringBuilder.append(this.left);
        }
        stringBuilder.append(getData() + "\n");
        if (this.right != null) {
            stringBuilder.append(this.right);
        }
        return stringBuilder.toString();

    }

}

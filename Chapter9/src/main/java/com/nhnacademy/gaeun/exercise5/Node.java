package com.nhnacademy.gaeun.exercise5;

public class Node<T> implements Comparable {
    public T value;
    public Node left;
    public Node right;
    public Node(T value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    @Override
    public int compareTo(Object o) {
        Node node = (Node) o;
        if(node.value instanceof Double) {
            return Double.compare((Double)this.value, (Double) node.value);
        }
        return 0;
    }
}

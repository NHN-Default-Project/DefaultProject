package com.nhnacademy.gaeun.exercise5;

public class Node implements Comparable {
    public double value;
    public Node left;
    public Node right;
    Node parent;
    public int depth;
    public Node(double value) {
        this(value, null);
    }
    public Node(double value, Node parent) {
        this.value = value;
        (this).parent = parent;
        this.right = null;
        this.left = null;
        this.depth = 0;
    }

    @Override
    public int compareTo(Object o) {
        Node node = (Node) o;
        return Double.compare(this.value, node.value);
    }
}

package com.nhnacademy.parkminsu.exercise9_2.solution;

public class Node {

    Node left;
    Node right;
    private String data;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
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

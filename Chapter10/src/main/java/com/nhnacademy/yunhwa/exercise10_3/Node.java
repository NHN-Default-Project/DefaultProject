package com.nhnacademy.yunhwa.exercise10_3;

public class Node {
    private String key;
    private String value;
    private Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
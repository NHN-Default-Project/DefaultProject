package com.nhnacademy.yunhwa.exercise10_3;

import java.util.LinkedList;

public class HashMap {
    private final int capacity;
    private final LinkedList<Node>[] buckets;

    public static class Node {
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

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];

        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public LinkedList<Node>[] getBuckets() {
        return this.buckets;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % this.capacity; // 배열 인덱스 계산

        if (index < 0) {
            index += capacity;
        }

        return index;
    }

    public String get(String key) {
        int index = getIndex(key);

        for (Node node : this.buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(String key, String value) {
        int index = getIndex(key);

        Node newNode = new Node(key, value);

        this.buckets[index].add(newNode);
    }

    public void remove(String key) {
        LinkedList<Node> removedList = new LinkedList<>();

        int index = getIndex(key);

        for (Node node : this.buckets[index]) {
            if (!node.key.equals(key)) {
                removedList.add(node);
            }
        }

        this.buckets[index] = removedList;
    }

    public boolean containsKey(String key) {
        int index = getIndex(key);
        for (Node node : this.buckets[index]) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;

        for (int i = 0; i < buckets.length; i++) {
            count += buckets[i].size();
        }

        return count;
    }

    public void printHashMap() {
        System.out.println(" ----------------- HashMap ------------------ ");
        System.out.println("         key         |         value      ");
        System.out.println(" -------------------------------------------- ");
        for (LinkedList<Node> linkedList : this.buckets) {
            for (Node node : linkedList) {
                System.out.printf("   %-17s |      %-20s%n", node.key, node.value);
            }
        }
        System.out.println(" -------------------------------------------- ");
    }
}

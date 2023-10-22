package com.nhnacademy.gaeun.exercise3;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Node>[] data;

    public HashTable(int size) {
        data = new LinkedList[size];
    }

    public String get(String key) {
        int index = getIndex(key.hashCode());
        if (data[index] != null) {
            for (Node node : data[index]) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    private int getIndex(int hashCode) {
        return Math.abs(hashCode) % data.length;
    }

    public void put(String key, String value) {
        if(key.equals("") || value.equals("")) {
            throw new NullPointerException("null값이 있습니다.");
        }
        int index = getIndex(key.hashCode());
        if (data[index] == null) {
            data[index] = new LinkedList<>();
            data[index].add(new Node(key, value));
        } else {
            for (Node node : data[index]) {
                if (node.key.hashCode() == key.hashCode()) {
                    data[index].remove(node);
                    data[index].add(new Node(key, value));
                    return;
                }
            }
            data[index].add(new Node(key, value));
        }
    }

    public void remove(String key) {
        int index = getIndex(key.hashCode());
        if (containsKey(key)) {
            for (Node node : data[index]) {
                if (node.key.equals(key)) {
                    data[index].remove(node);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("키값을 찾을 수 없습니다.");
        }
    }

    public boolean containsKey(String key) {
        int index = getIndex(key.hashCode());
        if (data[index] != null) {
            for (Node node : data[index]) {
                if (node.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        int size = 0;
        for (List list : data) {
            if (list != null) {
                size += list.size();
            }
        }
        return size;
    }
}

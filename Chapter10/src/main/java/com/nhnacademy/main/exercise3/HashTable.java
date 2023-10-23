package com.nhnacademy.main.exercise3;

import java.util.LinkedList;
import java.util.List;

/*
* https://math.hws.edu/javanotes/c10/exercises.html
* Java에서 제공하는 HashMap 클래스를 사용하지 않고,
* 문자열(String) 형식의 키와 값(key-value)을 저장할 수 있는 간단한 해시 테이블을 직접 구현.
* 이 해시 테이블은 get(key), put(key, value), remove(key), containsKey(key), size()와 같은 키-값 연산을 수행.
 */
public class HashTable {
    private static class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Node>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    public String get(String key) {
        int index = getIndex(key);
        if (data[index] != null) {
            for (Node node : data[index]) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    public int getIndex(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % data.length;
    }

    public void put(String key, String value) {
        if(key.isEmpty() || value.isEmpty()) {
            throw new NullPointerException("null값이 있습니다.");
        }
        int index = getIndex(key);
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
        int index = getIndex(key);
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
        int index = getIndex(key);
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

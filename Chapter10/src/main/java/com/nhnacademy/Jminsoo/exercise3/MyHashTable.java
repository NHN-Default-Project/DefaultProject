package com.nhnacademy.Jminsoo.exercise3;

import java.util.*;

/**
 * void get(key), void put(key,valye), void remove(key), boolean containKey(key), int size() 만들기
 */


public class MyHashTable {
    static final int TABLE_SIZE = 100;
    private final LinkedList<Node>[] nodeList;

    public MyHashTable() {
        this.nodeList = new LinkedList[TABLE_SIZE];
    }

    public int convertIndexByHash(int hashcode) {
        return hashcode % this.nodeList.length;
    }


    public String put(String key, String value) {
        int hashcode = Objects.hashCode(key);
        int index = convertIndexByHash(hashcode);

        LinkedList<Node> list = this.nodeList[index];

        if (list == null) {
            list = new LinkedList<>();
            this.nodeList[index] = list;

        }
        Node node = getNodeByKey(list, key);

        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.value = value;
        }

        return value;
    }

    public int size() {
        int count = 0;
        for (LinkedList<Node> list : this.nodeList) {
            if (list != null) {
                for (Node node : list) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public String get(String key) {
        int hashCode = Objects.hashCode(key);
        int index = convertIndexByHash(hashCode);

        LinkedList<Node> list = this.nodeList[index];

        Node node = getNodeByKey(list, key);
        return node == null ? null : node.value;

    }

    public boolean containsKey(String key) {
        int hashCode = Objects.hashCode(key);
        int index = convertIndexByHash(hashCode);

        LinkedList<Node> list = this.nodeList[index];

        for (Node node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(Object value) {
        for (LinkedList<Node> list : this.nodeList) {
            if (list != null) {

                for (Node node : list) {
                    if (node.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public String remove(String key) {
        int hashCode = Objects.hashCode(key);
        int index = convertIndexByHash(hashCode);

        LinkedList<Node> list = this.nodeList[index];

        Node node = getNodeByKey(list, key);
        String value = node.value;
        list.remove(node);
        return value;
    }

    public Set<String> keySet() {
        Set keySet = new HashSet<>();


        for (LinkedList<Node> list : this.nodeList) {
            if (list != null) {
                for (Node node : list) {
                    keySet.add(node.key);
                }
            }

        }

        return keySet;
    }

    public List<String> values() {
        List<String> valueSet = new ArrayList<>();

        for (LinkedList<Node> list : this.nodeList) {
            if (list != null) {

                for (Node node : list) {
                    valueSet.add(node.value);
                }
            }
        }
        return valueSet;
    }

    public Set<Map.Entry<String, String>> entrySet() {
        Set<Map.Entry<String, String>> entrySet = new HashSet<>();
        Map.Entry<String, String> entry;
        for (LinkedList<Node> list : this.nodeList) {
            if (list != null) {

                for (Node node : list) {
                    entry = new AbstractMap.SimpleEntry<>(node.key, node.value);
                    entrySet.add(entry);
                }
            }
        }
        return entrySet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : this.keySet()) {
            sb.append("키 : ")
                    .append(key)
                    .append(" 값 : ")
                    .append(this.get(key))
                    .append("\n");
        }
        return sb.toString();
    }

    private Node getNodeByKey(List<Node> list, Object key) {
        if (this.nodeList == null) {
            return null;
        }
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    private static class Node {
        String key;
        String value;


        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }
}

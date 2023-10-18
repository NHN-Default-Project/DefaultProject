package com.nhnacademy.parkminsu.exercise10_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    LinkedList<Node>[] nodes;
    private int count;

    public HashTable(int size) {
        nodes = new LinkedList[size];
    }

    public int getIndex(int hashCodeData) { // 인덱스 구하기
        return (hashCodeData & 0x7FFFFFFF) % nodes.length; // 음수 인덱스가 들어가지 않도록 0x7FFFFFFF 넣음
    }


    public String get(String key) {
        //1. key를 hashcode로 변환한다.
        //2. (1)에서 변환한 hashcode를 index로 변환한다.
        //3. searchKey 메서드로 해당 key를 갖고있는 Node를 찾는다.
        //4. Node가 null 이라면 key에 해당하는 값이 없다는 뜻이므로 null을 반환하고, null이 아니라면 key에 해당하는 값이 있다는 뜻이므로 value를 return 한다.
        int hashCode = key.hashCode(); // 1번
        int index = getIndex(hashCode); // 2번
        Node node = searchKey(this.nodes[index], key); // 3번

        return node == null ? null : node.value; // 4번
    }

    public boolean put(String key, String value) {
        int hashCode = key.hashCode(); // Key의 해쉬 코드 값 구하기
        int index = getIndex(hashCode); // 해쉬코드의 값을 구해서 index
        LinkedList<Node> list = nodes[index];
        if (list == null) {
            list = new LinkedList<Node>();
            nodes[index] = list;
        } // 해당 인덱스의 list가 null인 경우 new로 생성

        Node node = searchKey(list, key);
        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.value = value;
        }
        count++;
        return true;
    }

    public String remove(String key) {
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);
        LinkedList<Node> nodeList = this.nodes[index];
        if (this.nodes[index] != null) {
            String dataToRemove = searchKey(nodeList, key).value;
            this.nodes[index] = null;
            count--;
            return dataToRemove;
        }
        return null;
    }

    public boolean containKey(String key) { // key 값이 있는지, Search
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);
        for (Node node : this.nodes[index]) {
            if ((node.key.hashCode() == hashCode) && node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private Node searchKey(List<Node> list, String key) {
        if (list == null) {
            return null;
        }
        for (Node node : list) {
            if (key.equals(node.key)) {
                return node;
            }
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        return Arrays.toString(nodes);
    }

    private static class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return
                    key + ": " + value;
        }
    }

}

package com.nhnacademy.Jminsoo.exercise3;

/**
 * void get(key), void put(key,valye), void remove(key), boolean containKey(key), int size() 만들기
 */

import java.util.*;

/**
 * K : key
 * V : value
 */
//public class MyHashTable<T, E> implements Map<T, E> {
public class MyHashTable<T, E> {
    final static int TABLE_SIZE = 100;
    private LinkedList<Node<T, E>>[] nodeList;
//    private Node<T, E> tail;

    public MyHashTable() {
        this.nodeList = new LinkedList[TABLE_SIZE];
    }

    public int convertIndexByHash(int hashcode) {
        return hashcode % this.nodeList.length;
    }


    public E put(T key, E value) {
        int hashcode = Objects.hashCode(key);
        int index = convertIndexByHash(hashcode);
        LinkedList<Node<T, E>> list = this.nodeList[index];

        if (list == null) {
            list = new LinkedList<>();
            this.nodeList[index] = list;

        }
        Node<T, E> node = getNodeByKey(list, key);

        if (node == null) {
            list.addLast(new Node<>(key, value));
        } else {
            node.value = value;
        }

        return value;
    }

    public int size() {
        for (LinkedList<Node<T, E>> list : this.nodeList) {
            for (Node<T, E> node : list) {
                if (node.key.equals(value)) {
                    return true;
                }
            }
        }

//        int count = 0;
//        Node<T, E> runner = this.head;
//        while (runner != null) {
//            runner = runner.next;
//            count++;
//        }
//        return this.nodeList.length;
    }

    public boolean isEmpty() {
        return nodeList.length == 0;
    }

    public E get(Object key) {
        int hashCode = Objects.hashCode(key);
        int index = convertIndexByHash(hashCode);

        LinkedList<Node<T, E>> list = this.nodeList[index];

        Node<T, E> node = getNodeByKey(list, key);
        return node == null ? null : node.value;

//        Node<T, E> runner = this.head;
//        while (runner != null) {
//            if (runner.key.equals(key)) {
//                return runner.value;
//            }
//            runner = runner.next;
//        }
//        throw new NullPointerException();
    }

    public boolean containsKey(Object key) {
        int hashCode = Objects.hashCode(key);
        int index = convertIndexByHash(hashCode);

        LinkedList<Node<T, E>> list = this.nodeList[index];

        for (Node<T, E> node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }
//        while (runner != null) {
//            if (runner.key.equals(key)) {
//                return true;
//            }
//            runner = runner.next;
//        }
        return false;
    }

    public boolean containsValue(Object value) {
//        int hashCode = Objects.hashCode(key);
//        int index = convertIndexByHash(hashCode);

//        LinkedList<Node<T, E>> list = this.nodeList;

        for (LinkedList<Node<T, E>> list : this.nodeList) {
            for (Node<T, E> node : list) {
                if (node.key.equals(value)) {
                    return true;
                }
            }
        }
        return false;
//        for (LinkedList<Node<T, E>> list : this.nodeList) {
//            for (Node<T, E> node : list) {
//                if (node.value.equals(value)) {
//                    return true;
//                }
//            }
//        }

    }


    public E remove(Object key) {
        int hashCode = Objects.hashCode(key);
        int index = convertIndexByHash(hashCode);

        LinkedList<Node<T, E>> list = this.nodeList[index];

        Node<T, E> node = getNodeByKey(list, key);
        E value = node.value;
        list.remove(node);
        return value;

//        Node<T, E> runner = this.head;
//        Node<T, E> parentNode = runner;
//        Node<T, E> tempNode;
//        E result;
//
//        while (runner != null) {
//            if (containsKey(key)) {
//                if (runner.equals(this.head)) {
//                    this.head = head.next;
//                }
//                result = runner.value;
//                tempNode = runner.next;
//                parentNode.next = tempNode.next;
//                return result;
//            }
//            runner = runner.next;
//            parentNode = runner;
//        }
//        throw new NullPointerException();
    }

//    @Override
//    public void putAll(Map<? extends T, ? extends E> targetMap) {
//        targetMap.keySet().stream().forEach();
//        Node<T, E> runner = this.tail;
//        for (T key : targetMap.keySet()) {
//            runner.next = new Node<T, E>(Objects.hash(key), key, targetMap.get(key), null);
//            runner = runner.next;
//        }
//    }

//    @Override
//    public void clear() {
//        this.head = null;
//        this.tail = null;
//    }

    //    @Override
    public Set<T> keySet() {
        Set<T> keySet = new HashSet<>();

//        Node<T, E> runner = this.head;
//
//
//        while (runner != null) {
//            keySet.add(runner.key);
//            runner = runner.next;
//        }

        for (LinkedList<Node<T, E>> list : this.nodeList) {
            for (Node<T, E> node : list) {
                keySet.add(node.key);
                System.out.println(node.key);
            }
        }

        return keySet;
    }

    public Collection<E> values() {
        List<E> valueSet = new ArrayList<>();

        for (LinkedList<Node<T, E>> list : this.nodeList) {
            for (Node<T, E> node : list) {
                valueSet.add(node.value);
            }
        }
        return valueSet;
    }

    public Set<Map.Entry<T, E>> entrySet() {
        Set<Map.Entry<T, E>> entrySet = new HashSet<>();
        Map.Entry<T, E> entry;
        for (LinkedList<Node<T, E>> list : this.nodeList) {
            for (Node<T, E> node : list) {
                entry = new AbstractMap.SimpleEntry<>(node.key, node.value);
                entrySet.add(entry);
            }
        }
//        Node<T, E> runner = this.head;
//        while (runner != null) {
//            entry = new AbstractMap.SimpleEntry<>(runner.key, runner.value);
//            entrySet.add(entry);
//            runner = runner.next;
//        }
        return entrySet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T key : this.keySet()) {
            sb.append("키 : ")
                    .append(key.toString())
                    .append(" 값 : ")
                    .append(this.get(key))
                    .append("\n");
        }
        return sb.toString();
    }

    private Node<T, E> getNodeByKey(List<Node<T, E>> list, Object key) {
        if (this.nodeList == null) {
            return null;
        }
        for (Node<T, E> node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    private static class Node<T, E> {
        T key;
        E value;


        Node(T key, E value) {
//            this.hash = hash;
            this.key = key;
            this.value = value;
//            this.next = next;
        }

//        public void setNext(Node<T, E> node) {
//            this.next = node;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
    }
}

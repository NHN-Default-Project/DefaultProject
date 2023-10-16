package com.nhnacademy.Jminsoo.exercise3;

/**
 * TODO : void get(key), void put(key,valye), void remove(key), boolean containKey(key), int size() 만들기
 */

import java.util.*;

/**
 * K : key
 * V : value
 */
public class MyHashMap implements Map<String, String> {
    private Node head;
    private Node tail;

    public MyHashMap() {
    }

    @Override
    public String put(String key, String value) {
        if (head == null) {
            this.head = new Node(key.hashCode(), key, value, null);
            this.tail = head;
            return value;
        } else {
            tail.next = new Node(key.hashCode(), key, value, null);
            tail = tail.next;
        }
        return value;
    }

    @Override
    public int size() {
        int count = 0;
        Node runner = this.head;
        while (runner != null) {
            System.out.println(runner.key);
            runner = runner.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String get(Object key) {
        Node runner = this.head;
        while (runner != null) {
            if (runner.key.equals(key)) {
                return runner.value;
            }
            runner = runner.next;
        }
        throw new NullPointerException();
    }

    @Override
    public boolean containsKey(Object key) {
        Node runner = this.head;
        while (runner != null) {
            if (runner.key.equals(key)) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Node runner = this.head;
        while (runner != null) {
            if (runner.value.equals(value)) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }


    @Override
    public String remove(Object key) {
        Node runner = this.head;
        Node parentNode = runner;
        Node tempNode;
        String result;

        while (runner != null) {
            if (containsKey(key)) {
                if (runner.equals(this.head)) {
                    this.head = head.next;
                }
                result = runner.value;
                tempNode = runner.next;
                parentNode.next = tempNode.next;
                return result;
            }
            runner = runner.next;
            parentNode = runner;
        }
        throw new NullPointerException();
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> targetMap) {
        Node runner = this.tail;
        Iterator iter = targetMap.keySet().iterator();
        while (iter.hasNext()) {
            runner.next = (Node) iter.next();
            runner = runner.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public Set<String> keySet() {
        Set<String> keySet = new HashSet<>();

        Node runner = this.head;
        while (runner != null) {
            keySet.add(runner.key);
            runner = runner.next;
        }
        return keySet;
    }

    @Override
    public Collection<String> values() {
        List<String> valueSet = new ArrayList<>();

        Node runner = this.head;
        while (runner != null) {
            valueSet.add(runner.value);
            runner = runner.next;
        }
        return valueSet;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<Entry<String, String>> entrySet = new HashSet<>();
        Entry<String, String> entry;

        Node runner = this.head;
        while (runner != null) {
            entry = new AbstractMap.SimpleEntry<>(runner.key, runner.value);
            entrySet.add(entry);
            runner = runner.next;
        }
        return entrySet;
    }

    private class Node {
        int hash;
        String key;
        String value;
        Node next;


        Node(int hash, String key, String value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}

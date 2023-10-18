package com.nhnacademy.jaehyeon.exercise10_3;

import java.util.LinkedList;


public class HaspMapCustom {

    private static final int TABLE_SIZE = 1;
    private LinkedList<Entry>[] table;
    private int size;


    public HaspMapCustom() {
        this.table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            this.table[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    public void put(String key, String value) {
        if (key == null) {
            return;
        }
        int hash = key.hashCode(); //hashcode를 메소드를 호출하여 hashcode를 적용함
        int index = hash % TABLE_SIZE; // Entry 객체를 저장할 정확한 위치를 가져올 때 사용함

        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    public String get(String key) {
        int index = key.hashCode() % TABLE_SIZE;
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = key.hashCode() % TABLE_SIZE;
        LinkedList<Entry> list = table[index];
        Entry removeEntry = null;
        for (Entry entry : list) {
            if (entry.getKey().equals(key)) {
                removeEntry = entry;
                break;
            }
        }
        if (removeEntry != null) {
            list.remove(removeEntry);
            this.size--;
        }
    }

    public boolean containsKey(String key) {
        int index = key.hashCode() % TABLE_SIZE;
        LinkedList<Entry> list = table[index];
        for (Entry e : list) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }


    private static class Entry {
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

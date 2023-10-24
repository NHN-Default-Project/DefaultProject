package com.nhnacademy.gaeun.exercise3;

import java.util.Hashtable;

public class Exercise10_3 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put("간", "바보");
        hashTable.put("해시", "테이블");
        hashTable.put("커피", "중독");

        System.out.println("get(간): " + hashTable.get("간"));
        System.out.println("containsKey(해시): " + hashTable.containsKey("해시"));
        System.out.println("size: " + hashTable.size());
        hashTable.remove("간");
        System.out.println("간 remove 후: " + hashTable.size());
        System.out.println();
    }
}

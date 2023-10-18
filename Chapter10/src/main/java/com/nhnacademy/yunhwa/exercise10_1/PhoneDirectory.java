package com.nhnacademy.yunhwa.exercise10_1;

import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectory {
    private Map<String, String> data; // phone entries

    public PhoneDirectory() {
        data = new TreeMap<>();
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public String get(String name) {
        return this.data.get(name);
    }

    public void put(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name and number cannot be null");
        }
        this.data.put(name, number);
    }

    public void printPhoneDirectory() {
        System.out.println(" ------------- Phone Directory -------------- ");
        System.out.println("        Name         |      Phone Number      ");
        System.out.println(" -------------------------------------------- ");
        for (Map.Entry<String, String> entry : this.data.entrySet()) {
            System.out.printf("   %-17s |      %-20s%n", entry.getKey(), entry.getValue());
        }
    }
}

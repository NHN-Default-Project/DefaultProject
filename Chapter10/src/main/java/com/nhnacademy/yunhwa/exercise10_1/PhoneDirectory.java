package com.nhnacademy.yunhwa.exercise10_1;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PhoneDirectory {
    private Map<String, String> data; // phone entries

    public PhoneDirectory() {
        this.data = new TreeMap<>();
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public String getPhoneNumber(String name) {
        return this.data.get(name);
    }

    public void putNameAndPhoneNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name and number cannot be null");
        }
        this.data.put(name, number);
    }

    @Override
    public String toString() {
        return " ------------- Phone Directory -------------- \n"
                + "        Name         |      Phone Number      \n"
                + " -------------------------------------------- \n"
                + this.data.entrySet()
                .stream()
                .map(entry -> String.format("   %-17s |      %-20s%n", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(""));
    }
}

package com.nhnacademy.yunhwa.exercise10_1;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
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
        String nameFormat = "^[a-zA-Zㄱ-ㅎ가-힣\\s]*$";
        String numberFormat = "^\\d{2,3}-?\\d{3,4}-?\\d{4}$";

        if (name == null || number == null) {
            throw new IllegalArgumentException("name and number cannot be null");
        } else if (!Pattern.matches(nameFormat, name)) {
            throw new IllegalArgumentException("name format didn't match at all");
        } else if (!Pattern.matches(numberFormat, number)) {
            throw new IllegalArgumentException("number format didn't match at all");
        } else {
            this.data.put(name, number);
        }
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

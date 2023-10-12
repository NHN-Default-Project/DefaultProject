package com.nhnacademy.Jminsoo.exercise1;

import java.util.HashMap;
import java.util.Map;


public class PhoneDirectory {

    private static class PhoneEntry {
        String name;     // 이름.
        String number;   // 연관된 전화번호.
    }

    private Map<String, PhoneEntry> dataMap;

    public PhoneDirectory() {
        this.dataMap = new HashMap<>();
    }

    public String getNumber(String name) {
        return dataMap.getOrDefault(name, null).number;
    }

    public void putNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("이름과 전화번호는 null이 될 수 없습니다.");
        }
        PhoneEntry tempPhoneEntry = new PhoneEntry();
        tempPhoneEntry.name = name;
        tempPhoneEntry.number = number;
        dataMap.put(name, tempPhoneEntry);
    }
} // end class PhoneDirectory

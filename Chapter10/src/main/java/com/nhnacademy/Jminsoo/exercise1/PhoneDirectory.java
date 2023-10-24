package com.nhnacademy.Jminsoo.exercise1;

import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectory {

    private static class PhoneEntry {
        String name;     // 이름.
        String number;   // 전화번호.
    }

    private final Map<String, PhoneEntry> dataMap;

    public PhoneDirectory() {
        this.dataMap = new TreeMap<>();
    }

    public String getNumber(String name) {
        return dataMap.getOrDefault(name, new PhoneEntry()).number;
    }

    public void putNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("이름과 전화번호는 null이 될 수 없습니다.");
        }
        checkName(name);
        PhoneEntry tempPhoneEntry = new PhoneEntry();
        tempPhoneEntry.name = name;
        tempPhoneEntry.number = number;
        dataMap.put(name, tempPhoneEntry);
    }

    private void checkName(String name) {
        for (char chr : name.toCharArray()) {
            if (!Character.isLetter(chr)) {
                throw new IllegalArgumentException("이름에 문자가 아닌 값이 들어갔습니다!");
            }
        }
    }
} // end class PhoneDirectory

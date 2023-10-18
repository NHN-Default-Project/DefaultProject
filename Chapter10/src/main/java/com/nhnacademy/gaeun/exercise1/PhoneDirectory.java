package com.nhnacademy.gaeun.exercise1;

import lombok.Getter;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A PhoneDirectory holds a list of names with a phone number for
 * each name.  It is possible to find the number associated with
 * a given name, and to specify the phone number for a given name.
 */
public class PhoneDirectory {
    private final TreeMap<String, String> treeMapData;

    @Getter
    private int dataCount;

    public PhoneDirectory() {
        treeMapData = new TreeMap<>();
        dataCount = 0;
    }

    /**
     * Looks for a name/number pair with a given name.  If found, the index
     * of the pair in the data array is returned.  If no pair contains the
     * given name, then the return value is -1.  This private method is
     * used internally in getNumber() and putNumber().
     */
    public int find(String name) {
        Iterator<String> keyItr = treeMapData.keySet().iterator();
        for (int i = 0; i < dataCount; i++) {
            if (keyItr.next().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the phone number, if any, for a given name.
     *
     * @return The phone number associated with the name; if the name does
     * not occur in the phone directory, then the return value is null.
     */
    public String getNumber(String name) {
        if (!treeMapData.containsKey(name)) {
            throw new IllegalArgumentException("해당하는 이름이 연락처에 없습니다.");
        }
        return treeMapData.get(name);
    }

    /**
     * Associates a given name with a given phone number.  If the name
     * already exists in the phone directory, then the new number replaces
     * the old one.  Otherwise, a new name/number pair is added.  The
     * name and number should both be non-null.  An IllegalArgumentException
     * is thrown if this is not the case.
     */
    public void putNumber(String name, String number) {
        if (name.isEmpty() || number.isEmpty()) {
            throw new IllegalArgumentException("name and number cannot be null");
        }
        Pattern pattern = Pattern.compile("^\\d{3}-\\d{4}-\\d{4}$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.find()) {
            throw new IllegalArgumentException("000-0000-0000 형식으로 입력해주세요!");
        }
        treeMapData.put(name, number);
        dataCount = treeMapData.size();
    }

} // end class PhoneDirectory
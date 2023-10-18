package com.nhnacademy.jaehyeon.exercise10_1;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneDirectory {

    private TreeMap<String, String> phoneList;

    public PhoneDirectory() {
        phoneList = new TreeMap<>();
    }

    public void addNumber(String number, String name) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name and number cannot be null");
        }

        if (verifyPhoneNumber(number)) {
            this.phoneList.put(number, name);
        }

    }

    public boolean verifyPhoneNumber(String number) {
        try {
            String phoneNumberPattern = "^01[016789]-\\d{3,4}-\\d{4}$";

            Pattern pattern = Pattern.compile(phoneNumberPattern);
            Matcher matcher = pattern.matcher(number);

            if (!matcher.matches()) {
                throw new NotCorrectPhoneNumberFormat("전화번호를 알맞게 입력하세요");
            }
            return true;
        } catch (NotCorrectPhoneNumberFormat e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String lookUpName(String number) {
        verifyPhoneNumber(number);
        String findName;
        findName = this.phoneList.get(number);
        isExist(findName);
        return findName;
    }

    public String lookUpNumber(String name) {
        String findNumber = null;
        for (Map.Entry<String, String> entry : this.phoneList.entrySet()) {
            if (Objects.equals(entry.getValue(), name)) {
                findNumber = entry.getKey();
                break;
            }
        }
        isExist(findNumber);

        return findNumber;

    }

    public void isExist(String find) {
        try {
            if (find == null) {
                throw new NothingLookingFor("찾기를 원하시는 항목이 없습니다.");
            }
        } catch (NothingLookingFor e) {
            System.out.println(e.getMessage());
        }
    }


}
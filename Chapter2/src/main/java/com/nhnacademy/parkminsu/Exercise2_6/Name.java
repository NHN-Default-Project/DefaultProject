package com.nhnacademy.parkminsu.Exercise2_6;

public class Name {
    private String first;
    private String second;

    public Name(String str) {
        if (str.isEmpty()) {
            throw new StringIndexOutOfBoundsException("빈칸입니다.");

        }
        this.first = str.substring(0, str.indexOf(" "));
        this.second = str.substring(str.indexOf(" ") + 1, str.length());
    }

    public String getFirst() {
        return this.first;
    }

    public String getSecond() {
        return this.second;
    }

    public String initials() {
        return "" + this.first.charAt(0) + this.second.charAt(0);
    }
}

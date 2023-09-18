package com.nhnacademy.yunhwa.Exercise2_3;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getUpperName() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.name.length(); i++) {
            char c = this.name.charAt(i);

            if (c >= 'a' && c <= 'z') {
                stringBuilder.append((char) (c - ('a' - 'A')));
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

}

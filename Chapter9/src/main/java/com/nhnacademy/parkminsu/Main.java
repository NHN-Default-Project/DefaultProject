package com.nhnacademy.parkminsu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "[1,2,3]";
        Pattern pattern = Pattern.compile("[0-9*+-]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

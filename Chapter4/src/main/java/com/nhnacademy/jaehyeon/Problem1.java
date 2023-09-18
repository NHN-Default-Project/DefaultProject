package com.nhnacademy.jaehyeon;

public class Problem1 {


    public static void main(String[] args) {
        String str = "Now is the time to act!";

        printCapitalized(str);
    }

    public static void printCapitalized(String str) {
        StringBuilder sb = new StringBuilder();
        String[] splitString = splitString(str);

        for (int i = 0; i < splitString.length; i++) {
            sb.append(upperFirstString(splitString[i]));
            if (i != splitString.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static StringBuilder upperFirstString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (Character.isLetter(str.charAt(i))) {
                    if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                        sb.append(Character.toUpperCase(str.charAt(i)));
                    } else {
                        sb.append(str.charAt(i));
                    }
                } else {
                    sb.append(str.charAt(i));
                }

            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb;
    }


    private static String[] splitString(String str) {
        return str.split(" ");
    }


}



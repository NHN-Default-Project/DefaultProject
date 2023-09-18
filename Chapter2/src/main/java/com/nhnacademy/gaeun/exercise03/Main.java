package com.nhnacademy.gaeun.exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameSpace = scanner.nextLine();
        char[] charNameSpace = nameSpace.toCharArray();
        nameSpace = "";
        for (int i = 0; i < charNameSpace.length; i++) {
            if (charNameSpace[i] >= 97 && charNameSpace[i] <= 122)
                charNameSpace[i] -= 32;
            nameSpace += charNameSpace[i];
        }
        scanner.close();
        System.out.println("Hello, " + nameSpace + ", 만나서 반가워요!");
    }

}

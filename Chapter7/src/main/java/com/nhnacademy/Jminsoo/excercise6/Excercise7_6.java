package com.nhnacademy.Jminsoo.excercise6;

public class Excercise7_6 {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("Chapter7/src/main/java/com/nhnacademy/Jminsoo/excercise6/text.txt");
        readFile.print();

        readFile.toLowerCaseList();
        readFile.sort(false);
        readFile.print();
    }

}

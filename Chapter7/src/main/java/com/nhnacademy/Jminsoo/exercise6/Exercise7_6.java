package com.nhnacademy.Jminsoo.exercise6;

public class Exercise7_6 {
    public static void main(String[] args) {
        ReadAndWriteFile readFile = new ReadAndWriteFile("Chapter7/src/main/java/com/nhnacademy/Jminsoo/excercise6/text.txt");
        readFile.print();

        readFile.toLowerCaseList();
        readFile.removeDuplicates();
        readFile.sort(false);
        readFile.print();
        readFile.write();
    }

}

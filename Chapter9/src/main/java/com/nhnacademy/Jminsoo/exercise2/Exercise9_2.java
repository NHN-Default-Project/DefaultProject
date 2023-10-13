package com.nhnacademy.Jminsoo.exercise2;

public class Exercise9_2 {
    public static void main(String[] args) {
        ReadAndWriteFileByTree textFile = new ReadAndWriteFileByTree("Chapter9/src/main/java/com/nhnacademy/Jminsoo/exercise2/text.txt");
        textFile.print();
        textFile.writeToFile();
    }
}

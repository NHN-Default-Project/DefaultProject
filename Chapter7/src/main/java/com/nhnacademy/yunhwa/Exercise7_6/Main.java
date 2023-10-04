package com.nhnacademy.yunhwa.Exercise7_6;

public class Main {
    public static void main(String[] args) {
        ReadTxtToWriteSortedListByAsc readTxtToWriteSortedList = new ReadTxtToWriteSortedListByAsc();
//        readTxtToWriteSortedList.readTextFile("/Users/yoonhwachoi/Desktop/DefaultProject/Chapter7/src/main/java/com/nhnacademy/yunhwa/Exercise7_6/englishExample.txt");
        readTxtToWriteSortedList.readUserSelectedFile();
        readTxtToWriteSortedList.sortListByAlphabetical();
        readTxtToWriteSortedList.writeUserSelectedFile();
//        readTxtToWriteSortedList.writeTextFile("/Users/yoonhwachoi/Desktop/DefaultProject/Chapter7/src/main/java/com/nhnacademy/yunhwa/Exercise7_6/englishExampleResult.txt");
    }
}
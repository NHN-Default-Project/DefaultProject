package com.nhnacademy.yunhwa.Exercise7_6;

public class Main {
    public static void main(String[] args) {
        WritingToAnOutputFileSortedAlphabeticalListFromDiffrentWordsThatReadATextFile writeAfterSortedFromReadFile = new WritingToAnOutputFileSortedAlphabeticalListFromDiffrentWordsThatReadATextFile();
//        writeAfterSortedFromReadFile.readTextFile("/Users/yoonhwachoi/Desktop/DefaultProject/Chapter7/src/main/java/com/nhnacademy/yunhwa/Exercise7_6/englishExample.txt");
        writeAfterSortedFromReadFile.readUserSelectedFile();
        writeAfterSortedFromReadFile.printList();
        writeAfterSortedFromReadFile.sortListByAlphabetical();
        writeAfterSortedFromReadFile.writeUserSelectedFile();
//        writeAfterSortedFromReadFile.writeTextFile("/Users/yoonhwachoi/Desktop/DefaultProject/Chapter7/src/main/java/com/nhnacademy/yunhwa/Exercise7_6/englishExampleResult.txt");
    }
}
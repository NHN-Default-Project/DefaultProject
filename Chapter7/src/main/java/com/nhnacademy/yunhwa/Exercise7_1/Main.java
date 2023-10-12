package com.nhnacademy.yunhwa.Exercise7_1;

public class Main {

    public static void main(String[] args) {
        CreatingArrayListOfRandomNumsOfRange createArrList = new CreatingArrayListOfRandomNumsOfRange();
        createArrList.userInput();
        createArrList.makeArrayList(createArrList.getIntCount(), createArrList.getMaxIntNum());
        createArrList.printArrayList();
    }
}
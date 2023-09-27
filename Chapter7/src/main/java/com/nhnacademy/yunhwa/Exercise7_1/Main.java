package com.nhnacademy.yunhwa.Exercise7_1;

public class Main {

    public static void main(String[] args) {
        CreatingArrayListOfRandomNumsOfSpecifiedRange createArrayList = new CreatingArrayListOfRandomNumsOfSpecifiedRange();
        createArrayList.userInputBeforeAction();
        createArrayList.action(createArrayList.getIntCount(), createArrayList.getMaxIntNum());
        createArrayList.printConstructedArrayList();
    }
}
package com.nhnacademy.yunhwa.Exercise7_1;

public class Main {

    public static void main(String[] args) {
        CreateArrayListOfRandomNumsOfSpecifiedRange createArrayList = new CreateArrayListOfRandomNumsOfSpecifiedRange();
        createArrayList.userInputBeforeAction();
        createArrayList.action(createArrayList.getIntCount(), createArrayList.getMaxIntNum());
        createArrayList.printConstructedArrayList();
    }
}
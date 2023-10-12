package com.nhnacademy.parkminsu.exercise9_2.generic;

public class Main {
    //
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        String readFilePath = "/Users/minsu/Desktop/DefaultProject/Chapter9/src/main/java/com/nhnacademy/parkminsu/exercise9_2/generic/readfile.txt";
        String writeFilePath = "/Users/minsu/Desktop/DefaultProject/Chapter9/src/main/java/com/nhnacademy/parkminsu/exercise9_2/generic/input.txt";

        BinarySortTree binarySortTree = fileHandler.loadReadFile(new BinarySortTree(), readFilePath);
        fileHandler.loadWriteFile(binarySortTree, writeFilePath);

    }


}

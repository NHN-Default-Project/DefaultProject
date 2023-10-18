package com.nhnacademy.parkminsu.exercise9_2.solution;

public class Exercise9_2 {
    //
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        String readFilePath = "/Users/minsu/Desktop/DefaultProject/Chapter9/src/main/java/com/nhnacademy/parkminsu/exercise9_2/readfile.txt";
        String writeFilePath = "/Users/minsu/Desktop/DefaultProject/Chapter9/src/main/java/com/nhnacademy/parkminsu/exercise9_2/input.txt";

        BinarySortTree binarySortTree = fileHandler.loadReadFile(new BinarySortTree(), readFilePath);
        fileHandler.loadWriteFile(binarySortTree, writeFilePath);


    }


}

package com.nhnacademy.jaehyeon.exercise9_2;

import java.io.*;
import java.util.Arrays;

public class Exercise9_2 {
    public static void main(String[] args) {
        String inputFilePath = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Chapter9/src/main/java/com/nhnacademy/jaehyeon/exercise9_2/read.txt";
        String outputFilePath = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Chapter9/src/main/java/com/nhnacademy/jaehyeon/exercise9_2/write.txt";

        SortTree wordTree = new SortTree();
        fileRead(wordTree, inputFilePath);
        fileWrite(wordTree, outputFilePath);
    }

    private static void fileRead(SortTree sortTree, String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Arrays.stream(line.split(" "))
                        .forEach(s -> sortTree.insert(s.toLowerCase()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fileWrite(SortTree sortTree, String path) {
        try (PrintWriter writer = new PrintWriter(path)) {
            sortTree.writeTree(writer);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}

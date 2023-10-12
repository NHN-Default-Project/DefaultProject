package com.nhnacademy.jaehyeon.exercise9_2;

import java.io.*;
import java.util.Arrays;

public class Exercise9_2 {
    public static void main(String[] args) {
        String inputFilePath = "/Users/hyeon/Desktop/default_project/JaeHyeon/chapter9/exercise9_2/read.txt";
        String outputFilePath = "/Users/hyeon/Desktop/default_project/JaeHyeon/chapter9/exercise9_2/write.txt";

        SortTree wordTree = new SortTree();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Arrays.stream(line.split(" "))
                        .forEach(s -> wordTree.insert(s.toLowerCase()));
            }
        } catch (FileNotFoundException e) {
            //Todo
        } catch (IOException e) {
            //Todo
        }

        try (PrintWriter writer = new PrintWriter(outputFilePath)) {
            wordTree.writeTree(writer);
        } catch (FileNotFoundException e) {
            //Todo
        }
    }
}

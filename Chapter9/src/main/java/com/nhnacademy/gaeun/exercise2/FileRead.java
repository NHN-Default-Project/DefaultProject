package com.nhnacademy.gaeun.exercise2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;

import com.nhnacademy.gaeun.exercise2.WordTree.*;

import javax.swing.tree.TreeNode;

public class FileRead {
    private final String path;
    private WordTree wordTree;

    public FileRead(String path) {
        this.path = path;
        this.wordTree = new WordTree();
    }

    public WordTree load() {
        try(BufferedReader br = new BufferedReader( new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null) {
                List<String> wordOneLine = Arrays.stream(line.split(" "))
                        .map(x -> x.replaceAll("[^a-zA-Z0-9]", ""))
                        .collect(Collectors.toList());
                wordOneLine
                        .forEach(System.out::println);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordTree;
    }


}

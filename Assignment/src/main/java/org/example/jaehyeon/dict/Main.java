package org.example.jaehyeon.dict;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test4.json";
        File file = new File(path);
        Dictionary dictionary = new Dictionary(file);




    }
}

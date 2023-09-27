package org.example.jaehyeon.dict;//package com.nhnacademy.dict;
//
//import java.io.*;
//import java.util.List;
//import java.util.regex.Pattern;
//
//public class Problem2 implements Dictionary2 {
//    public static void main(String[] args) {
//        Problem2 problem2 = new Problem2();
//        problem2.load("d");
//    }
//
//    @Override
//    public void load(String path) {
//        String a = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test3.json";
//        File file = new File(a);
//        BufferedReader br = null;
//        String line = "";
//
//        try {
//            br = new BufferedReader(new FileReader(file));
//
//            while ((line = br.readLine()) != null) {
//                StringBuilder sb = new StringBuilder();
//
//                String d = line.replaceAll("[^0-9a-zA-Zㄱ-ㅎ가-힣]*$", "").replaceAll(" ", "");
//
//                System.out.println(d);
//
//
//
//
//            }
//        } catch (FileNotFoundException e) {
//            //Todo
//        } catch (IOException e) {
//            //Todo
//        }
//    }
//
//    @Override
//    public List<String> findEngByKor(String kor) {
//        return null;
//    }
//
//    @Override
//    public int count() {
//        return 0;
//    }
//
//    @Override
//    public List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
//        return null;
//    }
//}

package org.example.Jminsoo.test.Excercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.Jminsoo.dict.Excercise1.DictionaryApp1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DictionaryApp1Test {


    @DisplayName("Load Test")
    @Test
    void load() {
        DictionaryApp1 dictionaryApp1 = new DictionaryApp1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> dictionaryApp1.load(""));
        try {
            dictionaryApp1.load(
                    "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");
            dictionaryApp1.load(
                    "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("findEngByKor Test")
    @Test
    void findEngByKor() {
        DictionaryApp1 dictionaryApp1 = new DictionaryApp1();
        dictionaryApp1.load(
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");

        List<String> answerEng;
        List<String> testEng;

        answerEng = dictionaryApp1.findEngByKor("안녕");
        testEng = new ArrayList<>();
        testEng.add("Hello");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp1.findEngByKor("세상");
        testEng = new ArrayList<>();
        testEng.add("World");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        dictionaryApp1.load(
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");

        answerEng = dictionaryApp1.findEngByKor("안녕");
        testEng = new ArrayList<>();
        testEng.add("Hello");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp1.findEngByKor("세상");
        testEng = new ArrayList<>();
        testEng.add("World");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp1.findEngByKor("한국");
        testEng = new ArrayList<>();
        testEng.add("Korea");
        testEng.add("Republic of Korea");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);
    }

    @Test
    @DisplayName("count Test")
    void count() {
        DictionaryApp1 dictionaryApp1 = new DictionaryApp1();
        dictionaryApp1.load(
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");

        int answer;
        int test;

        answer = dictionaryApp1.count();
        test = 2;
        Assertions.assertEquals(answer, test);
        dictionaryApp1.load(
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");


        answer = dictionaryApp1.count();
        test = 3;
        Assertions.assertEquals(answer, test);

    }

    @Test
    void findAllListKor() {
        DictionaryApp1 dictionaryApp1 = new DictionaryApp1();
        dictionaryApp1.load(
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");

        Set<String> answer;
        Set<String> test;

        answer = dictionaryApp1.findAllListKor();
        test = new HashSet<>();
        test.add("안녕");
        test.add("세상");
        Assertions.assertEquals(answer.containsAll(test), true);

        dictionaryApp1.load(
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");


        answer = dictionaryApp1.findAllListKor();
        test = new HashSet<>();
        test.add("안녕");
        test.add("세상");
        test.add("한국");
        Assertions.assertEquals(answer.containsAll(test), true);

    }
}
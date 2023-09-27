package org.example.Jminsoo.test.Excercise2;

import org.example.Jminsoo.dict.Excercise2.CsvParser;
import org.example.Jminsoo.dict.Excercise2.DictionaryApp2;
import org.example.Jminsoo.dict.Excercise2.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DictionaryApp2Test {

    @DisplayName("Load Test")
    @Test
    void load() {
        DictionaryApp2 dictionaryApp1 = new DictionaryApp2();
        Assertions.assertThrows(IllegalArgumentException.class, () -> dictionaryApp1.load(new CsvParser(), ""));
        try {
            dictionaryApp1.load(new CsvParser(),
                    "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");
            dictionaryApp1.load(new CsvParser(),
                    "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");
            dictionaryApp1.load(new JsonParser(),
                    "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test3.json");
            dictionaryApp1.load(new JsonParser(),
                    "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test4.json");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("findEngByKor Test")
    @Test
    void findEngByKor() {
        DictionaryApp2 dictionaryApp2 = new DictionaryApp2();
        dictionaryApp2.load(new CsvParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");

        List<String> answerEng;
        List<String> testEng;

        answerEng = dictionaryApp2.findEngByKor("안녕");
        testEng = new ArrayList<>();
        testEng.add("Hello");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp2.findEngByKor("세상");
        testEng = new ArrayList<>();
        testEng.add("World");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        dictionaryApp2.load(new CsvParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");

        answerEng = dictionaryApp2.findEngByKor("안녕");
        testEng = new ArrayList<>();
        testEng.add("Hello");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp2.findEngByKor("세상");
        testEng = new ArrayList<>();
        testEng.add("World");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp2.findEngByKor("한국");
        testEng = new ArrayList<>();
        testEng.add("Korea");
        testEng.add("Republic of Korea");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        dictionaryApp2.load(new JsonParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test3.json");

        answerEng = dictionaryApp2.findEngByKor("안녕");
        testEng = new ArrayList<>();
        testEng.add("Hello");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp2.findEngByKor("세상");
        testEng = new ArrayList<>();
        testEng.add("World");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

        answerEng = dictionaryApp2.findEngByKor("한국");
        testEng = new ArrayList<>();
        testEng.add("Korea");
        testEng.add("Republic of Korea");
        Assertions.assertEquals(answerEng.containsAll(testEng), true);

    }

    @Test
    @DisplayName("countTest")
    void count() {
        DictionaryApp2 dictionaryApp = new DictionaryApp2();
        dictionaryApp.load(new CsvParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");

        int answer;
        int test;
        answer = dictionaryApp.count();
        test = 2;
        Assertions.assertEquals(answer, test);

        dictionaryApp.load(new CsvParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");
        answer = dictionaryApp.count();
        test = 3;
        Assertions.assertEquals(answer, test);

        dictionaryApp.load(new JsonParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test3.json");
        answer = dictionaryApp.count();
        test = 3;
        Assertions.assertEquals(answer, test);

        dictionaryApp.load(new JsonParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test4.json");
        answer = dictionaryApp.count();
        test = 4;
        Assertions.assertEquals(answer, test);
    }

    @Test
    void findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        DictionaryApp2 dictionaryApp = new DictionaryApp2();
        dictionaryApp.load(new CsvParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test1.csv");

        List<String> answer;
        List<String> test;
        answer = dictionaryApp.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
        test = new ArrayList<>();
        /*영단어 리스트*/
        test.add("Hello");
        test.add("World");
        System.out.println(answer);
        System.out.println(test);

        for (int i = 0; i < answer.size(); i++) {
            Assertions.assertEquals(answer.get(i).equals(test.get(i)), true);
        }

        dictionaryApp.load(new CsvParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test2.csv");


        answer = dictionaryApp.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
        test = new ArrayList<>();
        test.add("Korea");
        test.add("Republic of Korea");
        test.add("Hello");
        test.add("World");
        System.out.println(answer);
        System.out.println(test);

        for (int i = 0; i < answer.size(); i++) {
            Assertions.assertEquals(answer.get(i).equals(test.get(i)), true);

        }
        System.out.println();

        dictionaryApp.load(new JsonParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test3.json");

        answer = dictionaryApp.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
        test = new ArrayList<>();
        test.add("Korea");
        test.add("Republic of Korea");
        test.add("Hello");
        test.add("World");
        System.out.println(answer);
        System.out.println(test);
        for (int i = 0; i < answer.size(); i++) {
            Assertions.assertEquals(answer.get(i).equals(test.get(i)), true);
        }
        System.out.println();

        dictionaryApp.load(new JsonParser(),
                "/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/test/resources/test4.json");

        answer = dictionaryApp.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
        test = new ArrayList<>();
        test.add("Korea");
        test.add("Republic of Korea");
        test.add("USA");
        test.add("America");
        test.add("Hello");
        test.add("World");
        System.out.println(answer);
        System.out.println(test);
        for (int i = 0; i < answer.size(); i++) {
            Assertions.assertEquals(answer.get(i).equals(test.get(i)), true);
        }
        System.out.println();
    }
}
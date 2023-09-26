package com.nhnacademy.yunhwa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorEngDictionary2Test {

    KorEngDictionary2 korEngDictionary2;

    @BeforeEach
    void setUp() {
        korEngDictionary2 = new KorEngDictionary2();
    }

    @Test
    void load() {
        korEngDictionary2.load(new CSVParser(), "/Users/yoonhwachoi/Desktop/DefaultProject/Homework/src/test/resources/test1.csv");
        korEngDictionary2.load(new CSVParser(), "/Users/yoonhwachoi/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        korEngDictionary2.load(new JSONParser(), "/Users/yoonhwachoi/Desktop/DefaultProject/Homework/src/test/resources/test3.json");
        korEngDictionary2.load(new JSONParser(), "/Users/yoonhwachoi/Desktop/DefaultProject/Homework/src/test/resources/test4.json");
    }

    @Test
    void findEngByKor() {
    }

    @Test
    void count() {
    }

    @Test
    void findAllListKor() {
    }

    @Test
    void findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
    }
}
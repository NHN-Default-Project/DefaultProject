package org.example.parkminsu.dict;

import org.junit.jupiter.api.Assertions;

class DictionaryTest {

    @org.junit.jupiter.api.Test
    void load() {
        // given
        Dictionary dictionary = new Dictionary();

        // when
        // then
        Assertions.assertDoesNotThrow(() ->
                dictionary.load("/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test1.csv")
        ); // given when then 형식 지키기

    }

    @org.junit.jupiter.api.Test
    void findEngByKor() { // 파일을 더 추가해서 해보는 것도 괜찮을지도..?
        // given
        Dictionary dictionary = new Dictionary();
        dictionary.load("/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        // when

        // then
    }

    @org.junit.jupiter.api.Test
    void count() {
        Dictionary dictionary = new Dictionary();
        dictionary.load("/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        Assertions.assertEquals(3, dictionary.count());
    }

    @org.junit.jupiter.api.Test
    void findAllListKor() {
        Dictionary dictionary = new Dictionary();
        dictionary.load("/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        Dictionary compareDictionary = new Dictionary();
        compareDictionary.load("/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        Assertions.assertEquals(compareDictionary.findAllListKor(), dictionary.findAllListKor());
    }
}
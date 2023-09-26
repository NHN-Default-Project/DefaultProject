package org.example.parkminsu.dict;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dic2Test {

    @Test
    void loadCsvFile() {
        Dic2 dictionary = new Dic2();
        // when
        // then
        Assertions.assertDoesNotThrow(() ->
                dictionary.load(new CsvParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv")
        ); // given when then 형식 지키기

    }

    @Test
    void loadJsonFile() {


        Dic2 dictionary = new Dic2();
        // when
        // then
        dictionary.load(new JsonParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test4.json");
    }

    @Test
    void findEngByKorCsvFile() {
        Dic2 dictionary = new Dic2();
        dictionary.load(new CsvParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        System.out.println(dictionary.findEngByKor("한국"));
    }

    @Test
    void findEngByKorJsonFile() {
        Dic2 dictionary = new Dic2();
        dictionary.load(new JsonParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test4.json");
        System.out.println(dictionary.findEngByKor("미국"));
    }

    @Test
    void countCsvFile() {
        Dic2 dictionary = new Dic2();
        dictionary.load(new CsvParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        Assertions.assertEquals(3, dictionary.count());
    }

    @Test
    void countJsonFile() {
        Dic2 dictionary = new Dic2();
        dictionary.load(new JsonParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test3.json");
        Assertions.assertEquals(3, dictionary.count());
    }

    @Test
    void findAllEngByKorOrderByHomonymCountDescAndKorDesc() {

        Dic2 dictionary = new Dic2();
        dictionary.load(new CsvParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test2.csv");
        dictionary.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
    }

    @Test
    void findAllEngByKorOrderByHomonymCountDescAndKorDescJson() {

        Dic2 dictionary = new Dic2();
        dictionary.load(new JsonParser(), "/Users/minsu/Desktop/DefaultProject/Homework/src/test/resources/test4.json");
        dictionary.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
    }

}

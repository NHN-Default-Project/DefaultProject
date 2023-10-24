package org.example.gaeun;

import org.example.gaeun.parseFile.CsvDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CsvDictionaryTest {

    @Test
    @DisplayName("preCondition: load(path)")
    void preConditionLoadTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals("{세상=[World], 안녕=[Hello], 한국=[Korea, Republic of Korea]}"
                , csvDictionary.getDictionary().toString());
    }

    @Test
    @DisplayName("preCondition: fail load(path)")
    void preConditionFailLoadTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test3.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals("{}", csvDictionary.getDictionary().toString());
    }

    @Test
    @DisplayName("findEngByKor(kor) 확인")
    void findEngByKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals("[Korea, Republic of Korea]", csvDictionary.findEngByKor("한국").toString());
        Assertions.assertEquals("[World]", csvDictionary.findEngByKor("세상").toString());
        Assertions.assertEquals("[Hello]", csvDictionary.findEngByKor("안녕").toString());
    }

    @Test
    @DisplayName("preFindByKor(kor) 파일이 없는 경우 확인")
    void noFileFindByKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test3.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals("[]", csvDictionary.findEngByKor("한국").toString());
    }

    @Test
    @DisplayName("preFindByKor(kor) 해당 단어가 없는 경우 확인")
    void noWordFindByKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals("[]", csvDictionary.findEngByKor("인생").toString());
    }

    @Test
    @DisplayName("count 확인")
    void countTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals(3, csvDictionary.count());
    }

    @Test
    @DisplayName("findAllListKor 확인")
    void findAllListKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load(path);

        Assertions.assertEquals("[세상, 안녕, 한국]", csvDictionary.findAllListKor().toString());
    }


}
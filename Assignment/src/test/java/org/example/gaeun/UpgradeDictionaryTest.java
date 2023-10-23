package org.example.gaeun;

import org.example.gaeun.parseFile.UpgradeDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpgradeDictionaryTest {
    @Test
    @DisplayName("preCondition: load(path)")
    void preConditionLoadTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test4.json";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals("{세상=[World], 미국=[USA, America], 안녕=[Hello], 한국=[Korea, Republic of Korea]}"
                , upgradeDictionary.getDictionary().toString());
    }

    @Test
    @DisplayName("preCondition: fail load(path)")
    void preConditionFailLoadTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test3.csv";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals("{}", upgradeDictionary.getDictionary().toString());
    }

    @Test
    @DisplayName("findEngByKor(kor) 확인")
    void findEngByKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals("[Korea, Republic of Korea]", upgradeDictionary.findEngByKor("한국").toString());
        Assertions.assertEquals("[World]", upgradeDictionary.findEngByKor("세상").toString());
        Assertions.assertEquals("[Hello]", upgradeDictionary.findEngByKor("안녕").toString());
    }

    @Test
    @DisplayName("preFindByKor(kor) 파일이 없는 경우 확인")
    void noFileFindByKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test3.csv";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals("[]", upgradeDictionary.findEngByKor("한국").toString());
    }

    @Test
    @DisplayName("preFindByKor(kor) 해당 단어가 없는 경우 확인")
    void noWordFindByKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals("[]", upgradeDictionary.findEngByKor("인생").toString());
    }

    @Test
    @DisplayName("count 확인")
    void countTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test2.csv";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals(3, upgradeDictionary.count());
    }

    @Test
    @DisplayName("findAllListKor 확인")
    void findAllListKorTest() {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/test/resources/test4.json";
        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load(path);

        Assertions.assertEquals("[Korea, Republic of Korea, USA, America, Hello, World]", upgradeDictionary.findAllEngByKorOrderByHomonymCountDescAndKorDesc().toString());
    }

}
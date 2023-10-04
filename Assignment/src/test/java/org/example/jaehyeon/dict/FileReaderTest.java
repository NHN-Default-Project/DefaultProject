package org.example.jaehyeon.dict;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class FileReaderTest {
    Dictionary dictionary;

//    @DisplayName("load() test")
//    @Test
//    void loadTest() {
//        //given
//        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test3.json";
//        FileReader p = new FileReader();
//
//        //when
//        //then
//        Assertions.assertDoesNotThrow(() -> p.load(path));
//
//    }

//    @DisplayName("findEngByKor() Test")
//    @Test
//    void findEngByKorTest() {
//        //given
//        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test1.csv";
//        FileReader pro = new FileReader();
//        pro.load(path);
//
//        //when
//        List<String> result = pro.findEngByKor("안녕");
//
//        //then
//        List<String> answer = List.of("Hello", "dfdfd");
//        for (int i = 0; i < result.size(); i++) {
//            Assertions.assertEquals(result.get(i), answer.get(i));
//        }
//
//    }

//    @DisplayName("count() test")
//    @Test
//    void countTest() {
//        //given
//        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test1.csv";
//        FileReader pro = new FileReader();
//        pro.load(path);
//
//        //when
//        int result = pro.count();
//
//        //then
//        Assertions.assertEquals(result, 2);
//    }

//    @DisplayName("findAllListKor() test")
//    @Test
//    void findAllListKor() {
//        //given
//        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test1.csv";
//        FileReader pro = new FileReader();
//        pro.load(path);
//
//        //when
//        List<String> result = new ArrayList<>(pro.findAllListKor());
//
//        //then
//        List<String> answer = List.of("세상", "안녕");
//
//        for (int i = 0; i < result.size(); i++) {
//            Assertions.assertEquals(result.get(i), answer.get(i));
//        }
//    }

//    @DisplayName("")
//    @Test
//    void dTest(){
//        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test4.json";
//        FileReader pro = new FileReader();
//        pro.load(path);
//
//        pro.findAllEngByKorOrderByHomonymCountDescAndKorDesc();
//
//        for(String s : pro.findAllEngByKorOrderByHomonymCountDescAndKorDesc()){
//            System.out.println(s);
//        }
//    }

    @Test
    void findAllEngByKorOrderByHomonymCountAscAndKorAsc() {
        // given
        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test4.json";
        dictionary = new Dictionary(new File(path));

        // when
        List<String> actual = dictionary.findAllEngByKorOrderByHomonymCountAscAndKorAsc();

        for(String a : actual){
            System.out.println(a);
        }
        // then
        Assertions.assertEquals(6, actual.size());
    }
}
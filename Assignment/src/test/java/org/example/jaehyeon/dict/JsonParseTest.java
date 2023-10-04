package org.example.jaehyeon.dict;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

class JsonParseTest {

    @DisplayName("")
    @Test
    void parseFileTest() {
        //given
        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test4.json";
        File file = new File(path);

        //when
        JsonParse jsonParse = new JsonParse();
        int result = jsonParse.parseFile(file).keySet().size();

        //then
        Assertions.assertEquals(result, 4);
    }

    @DisplayName("")
    @Test
    void parseFileTest2() {
        //given
        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test4.json";
        File file = new File(path);

        //when
        JsonParse jsonParse = new JsonParse();
        int result = jsonParse.parseFile(file).values().size();

        //then
        Assertions.assertEquals(result, 4);
    }
}
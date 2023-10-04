package org.example.jaehyeon.dict;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CsvParseTest {

    @DisplayName("")
    @Test
    void parseFileTest(){
        //given
        String path = "/Users/hyeon/Desktop/DefaultProject/DefaultProject/Homework/src/test/resources/test1.json";
        File file = new File(path);

        //when
        CsvParse csvParse = new CsvParse();
        int result = csvParse.parseFile(file).keySet().size();


    }

}
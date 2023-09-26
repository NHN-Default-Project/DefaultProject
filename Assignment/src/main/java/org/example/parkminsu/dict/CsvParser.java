package org.example.parkminsu.dict;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParser implements Parser {
    Map<String, List<String>> dictionary;

    @Override
    public Map<String, List<String>> parse(String path) {
        String line = "";
        dictionary = new HashMap<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] strArr = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                List<String> list = dictionary.getOrDefault(strArr[0], new ArrayList<>());
                list.add(strArr[1]);

                dictionary.putIfAbsent(strArr[0], list);

            }
        } catch (IOException e) {
            System.out.println("에러 발생");
        } catch (NullPointerException e) {
            System.out.println("null pointer exception");
        }
        return dictionary;
    }
}

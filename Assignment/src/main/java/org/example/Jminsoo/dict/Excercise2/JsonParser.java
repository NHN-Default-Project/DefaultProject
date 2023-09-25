package org.example.Jminsoo.dict.Excercise2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser implements Parser {
    @Override
    public Map<String, List<String>> parse(String path) {
        File file = new File(path);
        Map<String, List<String>> result = new HashMap<>();
        if (!file.exists()) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다!");
        }

        try (Reader reader = new FileReader(path)) {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            List<String> value;


            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                String key = obj.keySet()
                        .iterator()
                        .next()
                        .toString();

                value = result.getOrDefault(key, new ArrayList<>());
                value.add(obj.get(key).toString());
                result.put(key, value);
            }

        } catch (IOException e) {
            throw new RuntimeException("파일을 찾을 수 없습니다!");
        } catch (ParseException e) {
            throw new RuntimeException("");
        }
        return result;
    }
}

package org.example.parkminsu.dict;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser implements Parser {
    Map<String, List<String>> dictionary;

    @Override
    public Map<String, List<String>> parse(String path) {
        dictionary = new HashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> json =
                    mapper.readValue(new File(path), new TypeReference<>() {
                    });


            for (int i = 0; i < json.size(); i++) {
                List<String> list = dictionary.getOrDefault(json.get(i).keySet().toString().replaceAll("[\\[\\]]", ""), new ArrayList<>());
                list.add(json.get(i).values().toString().replaceAll("[\\[\\]]", ""));
                dictionary.putIfAbsent(json.get(i).keySet().toString().replaceAll("[\\[\\]]", ""), list);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
        return dictionary;
    }
}

package org.example.jaehyeon.dict;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParse implements FileParse {

    @Override
    public Map<String, List<String>> parseFile(File file) {
        Map<String, List<String>> parseList = new HashMap<>();
        try (Reader reader = new FileReader(file)) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONArray jobj = (JSONArray) obj;

            for (Object object : jobj) {
                JSONObject jsonObj = (JSONObject) object;

                String first = jsonObj.keySet().toString().replaceAll("[\\[\\[\\]]", "");
                String second = jsonObj.values().toString().replaceAll("[\\[\\[\\]]", "");
//                String first = jsonObj.keySet().toString();
//                String second = jsonObj.values().toString();

                if (parseList.containsKey(first)) {
                    parseList.get(first).add(second);
                } else {
                    List<String> value = new ArrayList<>();
                    value.add(second);
                    parseList.put(first, value);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return parseList;
    }
}

package com.nhnacademy.yunhwa;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONParser implements Parser {


    @Override
    public Map<String, List<String>> parse(String path) {

        Map<String, List<String>> parsedDatas = new HashMap<>();

        List<KorEngs> korEngsList = new ArrayList<>();


        // 1. json 파일인 경우
        // 파일 읽어서 Map 타입 리턴
        Reader reader;
        try {
            reader = new FileReader(path);
            Gson gson = new Gson();
            KorEngs korEngs = gson.fromJson(reader, KorEngs.class);
            korEngsList.add(korEngs);

            for (KorEngs korEngsOne : korEngsList) {
                parsedDatas.put(korEngsOne.getKorWord(), korEngs.getEngWords());
            }


            // bufferedreader로 안되나?

//            BufferedReader bufReader = new BufferedReader(reader);
//
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = bufReader.readLine()) != null) {
//                JSONParser parser = new JSONParser();
//                JSONArray jsonArray = (JSONArray) parser.parse(line);
//
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    JSONArray jsonArrayArr = (JSONArray) jsonArray.get(i);
//                    String key = (String) jsonArrayArr.get(0);
//                    String value = (String) jsonArrayArr.get(1);
//
//                    if (parsedDatas.containsKey(key)) {
//                        parsedDatas.get(key).add(value);
//                    } else {
//                        List<String> list = new ArrayList<>();
//                        list.add(value);
//                        parsedDatas.put(key, list);
//                    }
//                }
//            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parsedDatas;
    }
}

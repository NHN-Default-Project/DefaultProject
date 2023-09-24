package org.example.Jminsoo.dict.Excercise2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class DictionaryApp2 implements Dictionary2 {
    Map<String, List<String>> data;

    @Override
    public void load(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다!");
        }

        this.data = new HashMap<>();

        if (path.endsWith("json")) {

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

                    value = this.data.get(key);
                    if (value == null) {
                        value = new ArrayList<>();
                    }
                    value.add(obj.get(key).toString());
                    System.out.println(value.get(0));

                    this.data.put(key, value);
                }

            } catch (IOException e) {
                throw new RuntimeException("파일을 찾을 수 없습니다!");
            } catch (ParseException e) {
                throw new RuntimeException("");
            }

        } else if (path.endsWith("csv")) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                List<String> tempList;

                while ((line = br.readLine()) != null) {
                    String[] str = line.split(",");
                    tempList = data.get(str[0]);

                    if (tempList == null) {
                        tempList = new ArrayList<>();
                    }
                    tempList.add(str[1]);

                    data.put(str[0], tempList);
                }

            } catch (NullPointerException | IOException e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException("파일을 읽어들일 수 없습니다!");
            }
        }
    }

    @Override
    public List<String> findEngByKor(String kor) {
//        System.out.println(kor);
//        System.out.println(data.get(kor));
        return data.get(kor);
    }

    @Override
    public int count() {
        return data.size();
    }

    @Override
    public List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        List<String> result = new ArrayList<>();
        Iterator<List<String>> iterator = this.data.values().iterator();
        while (iterator.hasNext()) {
            List<String> values = iterator.next();
            for (String value : values) {
                result.add(value);
            }

        }
        Collections.sort(result);

        return result;
    }
}

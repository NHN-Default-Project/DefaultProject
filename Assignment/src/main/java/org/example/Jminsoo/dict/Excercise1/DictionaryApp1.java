package org.example.Jminsoo.dict.Excercise1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DictionaryApp1 implements Dictionary1 {


//    private CSVFile csvFile;

    Map<String, ArrayList<String>> data;

    @Override
    public void load(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다!");
        }

        this.data = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> tempSet;

            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                tempSet = data.get(str[0]);

                if (tempSet == null) {
                    tempSet = new ArrayList<>();
                }
                tempSet.add(str[1]);

                data.put(str[0], tempSet);
            }

        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("파일을 읽어들일 수 없습니다!");
        }

    }

    @Override
    public List<String> findEngByKor(String kor) {
        return data.get(kor);
    }

    @Override
    public int count() {
        return data.size();
    }

    @Override
    public Set<String> findAllListKor() {
        return data.keySet();
    }
}
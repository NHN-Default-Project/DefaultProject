package org.example.parkminsu.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> load(String path) {
        String line = "";
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            String[] movieColum = bufferedReader.readLine().split(";");
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(line);
                if (movieColum.length > line.split(";").length) {
                    stringBuilder.append(bufferedReader.readLine());
                } // ?
                list.add(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

package org.example.gaeun.parseFile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonFile implements FileObject {
    private HashMap<String, List<String>> dictionary;
    File file;

    JsonFile() {
        dictionary = new HashMap<>();
    }

    @Override
    public HashMap<String, List<String>> loadFile(String path) {
        JSONParser parser = new JSONParser();
        file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(path));) {

            String data;
            StringBuilder sb = new StringBuilder();
            while((data = br.readLine()) != null) {
                sb.append(data);
            }
            data = sb.toString();

            JSONArray jsonArray = (JSONArray) parser.parse(data);
            for(int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                String kor = obj.keySet().toString();
                kor = kor.substring(1, kor.length() -1);
                String eng = (String) obj.get(kor);
                if (dictionary.containsKey(kor)) {
                    dictionary.get(kor).add(eng);
                } else {
                    List<String> engMeans = new ArrayList<>();
                    engMeans.add(eng);
                    dictionary.put(kor, engMeans);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return dictionary;
    }




//            while (scanner.hasNextLine()) {
//                String loadOneLine = scanner.nextLine().trim();
//                if (loadOneLine.equals("[") || loadOneLine.equals("]") || loadOneLine.equals("},") || loadOneLine.equals("{") || loadOneLine.equals("}")) {
//                    continue;
//                }
//                String kor = loadOneLine.substring(1, loadOneLine.indexOf(":") - 1);
//                String eng = loadOneLine.substring(loadOneLine.indexOf(":") + 3, loadOneLine.length() - 1);
//
//                if (dictionary.containsKey(kor)) {
//                    dictionary.get(kor).add(eng);
//                } else {
//                    List<String> engMeans = new ArrayList<>();
//                    engMeans.add(eng);
//                    dictionary.put(kor, engMeans);
//                }
//            }

//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        return dictionary;
//    }
}

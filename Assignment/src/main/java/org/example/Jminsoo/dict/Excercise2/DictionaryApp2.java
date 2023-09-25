package org.example.Jminsoo.dict.Excercise2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DictionaryApp2 implements Dictionary2 {
    Map<String, List<String>> data;

    @Override
    public void load(Parser parser, String path) {
        this.data = parser.parse(path);
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
    public List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        return this.data.keySet()
                .stream()
                .sorted(Comparator.comparing(x -> this.data.get(x).size())
                        .thenComparing(Object::toString).reversed())
                .map(x -> this.data.get(x))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}

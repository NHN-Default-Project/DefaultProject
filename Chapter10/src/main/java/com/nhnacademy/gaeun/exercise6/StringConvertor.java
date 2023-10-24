package com.nhnacademy.gaeun.exercise6;

import java.util.*;
import java.util.stream.Collectors;

public class StringConvertor {

    private Map<String, List<Integer>> wordToMap;

    public StringConvertor() {
        wordToMap = new TreeMap<>();
    }

    public Map<String, List<Integer>> getWordToMap() {
        return wordToMap;
    }

    /**
     * 주어진 문자열 목록을 처리하여 단어 목록을 생성하고 인덱스와 함께 저장한 후,
     * 단어와 인덱스를 매핑한 맵을 반환합니다.
     *
     * @param readLines 처리할 문자열 목록입니다.
     * @return 단어와 인덱스를 매핑한 맵(Map)입니다.
     */
    public void convertToWordMap(List<String> readLines) {
        int index = 1;
        for (String oneLine : readLines) {
            convertToWord(oneLine, index);
            index = index + 1;
        }
    }

    /**
     * 주어진 문자열을 처리하여 단어 목록을 생성하고 인덱스와 함께 저장합니다.
     *
     * @param oneLine 처리할 문자열입니다.
     * @param index   현재 처리 중인 문자열의 인덱스입니다.
     */
    private void convertToWord(String oneLine, int index) {
        java.util.List<String> words = Arrays.stream(oneLine.split(" "))
                .map(n -> n.replaceAll("^\\.|\\.$", ""))
                .map(n -> n.replaceAll("[^a-zA-Z0-9가-힣.]", ""))
                .filter(n -> n.length() >= 3)
                .map(n -> n.replaceAll("(?i)\\bthe\\b", "").toLowerCase())
                .collect(Collectors.toList());

        // 처리된 단어 목록과 인덱스를 저장하는 메서드를 호출합니다.
        saveWordToMap(words, index);
    }

    private void saveWordToMap(List<String> words, int index) {
        words = words.stream().distinct().collect(Collectors.toList());
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            this.wordToMap.put(word, this.wordToMap.getOrDefault(word, new ArrayList<>()));
            this.wordToMap.get(word).add(index);
        }
    }

    public void sortWordMap() {
        Map<String, List<Integer>> sortMap = new LinkedHashMap<>();
        List<String> keySet = new ArrayList<>(wordToMap.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            sortMap.put(key, wordToMap.get(key));
        }
        this.wordToMap = sortMap;
    }
}

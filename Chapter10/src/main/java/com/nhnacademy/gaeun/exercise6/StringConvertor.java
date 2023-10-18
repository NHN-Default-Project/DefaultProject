package com.nhnacademy.gaeun.exercise6;

import java.util.*;
import java.util.stream.Collectors;

public class StringConvertor {

    private static Map<String, List<Integer>> wordToMap;

    private StringConvertor() {
        wordToMap = new HashMap<>();
    }

    public static StringConvertor get() {
        return new StringConvertor();
    }

    /**
     * 주어진 문자열 목록을 처리하여 단어 목록을 생성하고 인덱스와 함께 저장한 후,
     * 단어와 인덱스를 매핑한 맵을 반환합니다.
     *
     * @param readLines 처리할 문자열 목록입니다.
     * @return 단어와 인덱스를 매핑한 맵(Map)입니다.
     */
    public Map<String, List<Integer>> convertToWordMap(List<String> readLines) {
        int index = 1;
        for (String oneLine : readLines) {
            convertToWord(oneLine, index);
            index = index + 1;
        }
        return wordToMap;
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
                .map(n -> n.replace("\\bthe\\b", "").toLowerCase())
                .collect(Collectors.toList());

        // 처리된 단어 목록과 인덱스를 저장하는 메서드를 호출합니다.
        saveWordToMap(words, index);
    }

    private void saveWordToMap(List<String> words, int index) {
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (wordToMap.containsKey(word)) {
                wordToMap.get(word).add(index);
            } else {
                List<Integer> countLineList = new ArrayList<>();
                countLineList.add(index);
                wordToMap.put(word, countLineList);
            }
        }
    }
}

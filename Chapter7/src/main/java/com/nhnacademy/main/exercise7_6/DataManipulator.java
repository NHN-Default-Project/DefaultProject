package com.nhnacademy.main.exercise7_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DataManipulator {
    private DataManipulator() {
    }

    public static List<String> removeDuplicateChar(List<String> wordsList) {
        Set<String> strSet = Set.copyOf(wordsList);
        return new ArrayList<>(strSet);
    }


    public static List<String> sortListByAlphabetical(List<String> wordsList) {
        Collections.sort(wordsList);
        return wordsList;
    }
}

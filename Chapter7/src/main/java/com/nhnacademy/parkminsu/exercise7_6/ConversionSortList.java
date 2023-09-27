package com.nhnacademy.parkminsu.exercise7_6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionSortList {
    private List<String> sortList;

    public ConversionSortList() {
        sortList = new ArrayList<>();
    }

    public List<String> sort(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> conversion(List<String> list) {
        return list.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
    }
}

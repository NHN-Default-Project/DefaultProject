package com.nhnacademy.parkminsu.exercise10_4;

import com.nhnacademy.parkminsu.exercise10_4.exception.NegativeNumException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class ListRandomOfValue<T> {
    private List<T> listOfRandomValues;
    private final int size;

    public ListRandomOfValue(int size) throws NegativeNumException {
        isCheckIfSizeIsNegativeNum(size);
        this.size = size;
        this.listOfRandomValues = new ArrayList<>();
    }

    public List<T> generateListOfRandomValues(Function<Random, T> randomTFunction, int size) {
        List<T> listOfRandomValues = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            listOfRandomValues.add(randomTFunction.apply(random));
        }
        return listOfRandomValues;
    }

    private void isCheckIfSizeIsNegativeNum(int size) throws NegativeNumException {
        if (isSizeNegativeNum(size)) {
            throw new NegativeNumException("0 또는 음수를 입력하셨습니다");
        }
    }

    private boolean isSizeNegativeNum(int size) {
        return size <= 0;
    }

    public List<T> getListOfRandomValues() {
        return listOfRandomValues;
    }

    public int getSize() {
        return size;
    }
}

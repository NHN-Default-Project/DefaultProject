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
        isCheckNegativeNum(size);
        this.size = size;
        this.listOfRandomValues = new ArrayList<>();
    }


    public void generateListOfRandomValues(Function<Random, T> randomTFunction, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            listOfRandomValues.add(randomTFunction.apply(random));
        }
    }

    /**
     * 해당 데이터가 음수이면 Throw를 던져주는 메서드
     */
    private void isCheckNegativeNum(int data) throws NegativeNumException {
        if (isNegativeNum(data)) {
            throw new NegativeNumException("음수를 입력하셨습니다");
        }
    }

    /**
     * 해당 data의 값이 음수인지 판별하는 메서드
     */
    private boolean isNegativeNum(int data) {
        return data < 0;
    }

    public List<T> getListOfRandomValues() {
        return listOfRandomValues;
    }

    public int getSize() {
        return size;
    }
}

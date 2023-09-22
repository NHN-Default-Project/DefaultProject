package com.nhnacademy.yunhwa.Exercise4_5;

import java.util.stream.DoubleStream;

public class ArrayProcessors {
    public static final ArrayProcessor maximumOfArray = (array) -> DoubleStream.of(array).max().getAsDouble();
    public static final ArrayProcessor minimumOfArray = (array) -> DoubleStream.of(array).min().getAsDouble();
    public static final ArrayProcessor sumOfArray = (array) -> DoubleStream.of(array).sum();
    public static final ArrayProcessor averageOfArray = (array) -> DoubleStream.of(array).average().getAsDouble();

    public static ArrayProcessor counter(double value) {
        // value가 array에 몇 개 있는지 찾아 반환하는 람다식 작성해서 리턴

        ArrayProcessor countThisValueInArray = (array) -> DoubleStream.of(array).filter(x -> x == value).count();
        return countThisValueInArray;
    }
}
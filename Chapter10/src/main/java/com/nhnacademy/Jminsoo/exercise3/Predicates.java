package com.nhnacademy.Jminsoo.exercise3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

    public static <T> void removeAll(Predicate<T> pred, Collection<T> coll) {

    }

    public static <T> List<T> collect(Predicate<T> pred, Collection<T> coll) {
        List<T> resultList = new ArrayList<>();
        for (T data : coll) {
            if (pred.test(data)) {
                resultList.add(data);
            }
        }
        return resultList;
    }
}

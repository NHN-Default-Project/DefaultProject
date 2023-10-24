package com.nhnacademy.parkminsu.exercise10_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Predicates<T extends Iterator<T>> {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        // pred.test(obj)가 true인 경우 coll에서 모든 객체 obj를 제거합니다.
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                iterator.remove();
            }
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        // pred.test(obj)가 false인 경우 coll에서 모든 객체 obj를 제거합니다.
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (!pred.test(item)) {
                iterator.remove();
            }
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        // pred.test(obj)가 true인 경우 컬렉션 coll에서 pred.test(obj)가 true인 모든 객체 obj를 포함하는 List를 반환합니다.
        List<T> collectList = new ArrayList<>();
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                collectList.add(item);
            }
        }
        return collectList;
    }

    public static <T> int find(Collection<T> list, Predicate<T> pred) {
        // 리스트 list에서 처음으로 pred.test(obj)가 true인 항목의 인덱스를 반환합니다. 일치하는 항목이 없는 경우 -1을 반환합니다.
        Iterator<T> iterator = list.iterator();
        int findIndex = -1;
        while (iterator.hasNext()) {
            T item = iterator.next();
            findIndex++;
            if (pred.test(item)) {
                return findIndex;
            }
        }
        return -1;
    }
}

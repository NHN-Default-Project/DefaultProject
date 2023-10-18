package com.nhnacademy.Jminsoo.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iter = coll.iterator();
        while (iter.hasNext()) {
            T data = iter.next();
            if (pred.test(data)) {
                iter.remove();
            }
        }
    }
    // pred.test(obj)가 true인 경우 coll에서 모든 객체 obj를 제거합니다. (coll.removeIf(pred)와 동일합니다.)

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iter = coll.iterator();
        while (iter.hasNext()) {
            T data = iter.next();
            if (!pred.test(data)) {
                iter.remove();
            }
        }
    }
    // pred.test(obj)가 false인 경우 coll에서 모든 객체 obj를 제거합니다. (즉, 조건이 참인 객체만 유지합니다.)

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> resultList = new ArrayList<>();
        Iterator<T> iter = coll.iterator();
        while (iter.hasNext()) {
            T data = iter.next();
            if (pred.test(data)) {
                resultList.add(data);
            }
        }

        return resultList;
    }
    // pred.test(obj)가 true인 경우 컬렉션 coll의 모든 객체 obj를 포함하는 List를 반환합니다.

    public static <T> int find(List<T> list, Predicate<T> pred) {
        Iterator<T> iter = list.iterator();
        while (iter.hasNext()) {
            T data = iter.next();
            if (!pred.test(data)) {
                return list.indexOf(data);
            }
        }
        return -1;
    }
    // 조건이 참인 첫 번째 항목의 인덱스를 반환합니다. 조건이 참인 항목이 없는 경우 -1을 반환합니다.
}

package com.nhnacademy.main.exercise10_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            if (pred.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            if (! pred.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> tList = new ArrayList<>();

        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (pred.test(t)) {
                tList.add(t);
            }
        }

        return tList;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (int i = 0; i < list.size(); i++) {
            if (pred.test(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

}
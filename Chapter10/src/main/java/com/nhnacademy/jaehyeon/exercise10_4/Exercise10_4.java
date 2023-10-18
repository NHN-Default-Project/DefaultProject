package com.nhnacademy.jaehyeon.exercise10_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Exercise10_4 {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T object = iterator.next();
            if (pred.test(object)) {
                iterator.remove();
            }
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T object = iterator.next();
            if (!pred.test(object)) {
                iterator.remove();
            }
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T object = iterator.next();
            if (pred.test(object)) {
                list.add(object);
            }
        }
        return list;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (T item : list) {
            if (pred.test(item)) {
                return list.indexOf(item);
            }
        }
        return -1;
    }
}

package com.nhnacademy.gaeun.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Exercise10_4 {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        for(T t : coll) {
            if(pred.test(t)) {
                coll.remove(t);
            }
        }
    }
    // Remove every object, obj, from coll for which pred.test(obj)
    // is true.  (This does the same thing as coll.removeIf(pred).)

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        for(T t : coll) {
            if(!pred.test(t)) {
                coll.remove(t);
            }
        }
    }
    // Remove every object, obj, from coll for which
    // pred.test(obj) is false.  (That is, retain the
    // objects for which the predicate is true.)

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        for(T t : coll) {
            if(pred.test(t)) {
                list.add(t);
            }
        }
        return list;
    }
    // Return a List that contains all the objects, obj,
    // from the collection, coll, such that pred.test(obj)
    // is true.

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        int index = -1;
        for(T t : list) {
            if(pred.test(t)) {
                return list.indexOf(t);
            }
        }
        return index;
    }
    // Return the index of the first item in list
    // for which the predicate is true, if any.
    // If there is no such item, return -1.
}

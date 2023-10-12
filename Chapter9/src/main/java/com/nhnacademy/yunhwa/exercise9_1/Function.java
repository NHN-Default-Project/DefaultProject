package com.nhnacademy.yunhwa.exercise9_1;

@FunctionalInterface
public interface Function<T> {
    T apply(T t);
}
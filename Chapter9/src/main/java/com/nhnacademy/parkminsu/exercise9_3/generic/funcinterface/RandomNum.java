package com.nhnacademy.parkminsu.exercise9_3.generic.funcinterface;

public interface RandomNum<T, R> { // 구현하려다가 멈춤
    R apply(T value);

}

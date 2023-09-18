package com.nhnacademy.gaeun.exercise05;

import com.sun.jdi.ArrayReference;
import java.lang.reflect.Array;

@FunctionalInterface
public interface ArrayProcessor {
    double apply(double[] array);
}

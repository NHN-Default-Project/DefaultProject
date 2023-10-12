package org.example.yunhwa;

import java.util.Arrays;

public class AllCollection {
    public AllCollection() {
        All gcdAll = (x) -> { return Arrays.stream(x).reduce(0, Math::gcd)};
        All gcdAllAll = (x) -> {
            T[] tArr = new T[x.length];
            for (int i = 0; i < x.length; i++) {
                tArr[i] = gcdAll(x[i]);
            }
            return tArr;
        };
        All maxAll = (x) -> { return Arrays.stream(x).reduce(0, Math::max)};
    }
}
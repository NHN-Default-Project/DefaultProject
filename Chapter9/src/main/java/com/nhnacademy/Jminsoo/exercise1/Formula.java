package com.nhnacademy.Jminsoo.exercise1;

import java.math.BigInteger;

public interface Formula {
    void precondition(String input);

    BigInteger apply(BigInteger bi);
}

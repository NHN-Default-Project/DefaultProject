package com.nhnacademy.yunhwa.exercise8_3;

import java.math.BigInteger;
import java.util.*;

public class StandardRomanNumerals {
    static final List<String> BASIC_ROMAN = List.of("M", "D", "C", "L", "X", "V", "I");
    static final Map<String, Integer> ROMAN_NUMERALS = Map.ofEntries(
            Map.entry("M", 1000),
            Map.entry("CM", 900),
            Map.entry("D", 500),
            Map.entry("CD", 400),
            Map.entry("C", 100),
            Map.entry("XC", 90),
            Map.entry("L", 50),
            Map.entry("XL", 40),
            Map.entry("X", 10),
            Map.entry("IX", 9),
            Map.entry("V", 5),
            Map.entry("IV", 4),
            Map.entry("I", 1)
            );

    private StandardRomanNumerals() {
    }

}
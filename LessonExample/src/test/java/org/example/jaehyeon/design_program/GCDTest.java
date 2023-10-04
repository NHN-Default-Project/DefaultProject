package org.example.jaehyeon.design_program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GCDTest {

    @DisplayName("preConditionNumber() test")
    @Test
    void preConditionNumberTest() {
        //given
        int[] numbers = {0, 1};

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Gcd(numbers);
        });
    }

    @DisplayName("gcd result test")
    @Test
    void gcdResultTest() {
        //given
        int[] numbers = {100, 50, 25};

        //when
        Gcd gcd = new Gcd(numbers);

        //then
        int result = 25;
        Assertions.assertEquals(gcd.getGcd(), result);
    }


}
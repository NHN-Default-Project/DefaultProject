package org.example.jaehyeon.design_program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxGCDTest {

    @DisplayName("maxGcd result test")
    @Test
    void maxGcdTest() {
        //given
        int[] numbers = {2, 4, 6};
        int r = 2;

        //when
        MaxGCD maxGCD = new MaxGCD(numbers, r);

        //then
        int result = 2;
        Assertions.assertEquals(maxGCD.getGcdMax(), result);

    }


}
package org.example.jaehyeon.design_program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationTest {

    @DisplayName("preConditionArraySize() test")
    @Test
    void preConditionArraySizeTest() {
        //given
        int[] array = {1, 2};
        int r = 3;

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Combination(array, r);
        });
    }

    @DisplayName("preConditionSubSet() test")
    @Test
    void preConditionSubSetTest() {
        //given
        int[] array = {1};
        int r = -1;

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Combination(array, r);
        });
    }

    @DisplayName("preConditionSequences() test")
    @Test
    void preConditionSequences() {
        //given
        int[] array = {0, 1};
        int r = 1;

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Combination(array, r);
        });
    }

    @DisplayName("combination result test")
    @Test
    void combinationTest() {
        //given
        int[] array = {1, 2, 3};
        int r = 2;

        //when
        Combination combination = new Combination(array,r);

        //then
        List<int[]> result = List.of(
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3});
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertArrayEquals(result.get(i), combination.getCombiList().get(i));
        }

    }


}
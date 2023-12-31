package org.example.gaeun.design_programs;

import java.util.Arrays;
import java.util.Comparator;

public class MaxAll implements All<Integer> {

    @Override
    public Integer all(Integer[] array) {;
        int maxAnswer = array[0];
        for(int val : array) {
            if(maxAnswer < val) {
                maxAnswer = val;
            }
        }
        return maxAnswer;
    }

}

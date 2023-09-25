package org.example.gaeun.design_programs;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    boolean[] visited;

    public Integer[][] getTwoArray() {
        return twoArray;
    }

    Integer[][] twoArray;
    List<Integer> tmpList;


    public boolean[] getVisited() {
        return visited;
    }

    Combination(Integer[] array, int r) {
        twoArray = new Integer[combinationValue(array.length, r)][r];
        visited = new boolean[array.length];
        tmpList = new ArrayList(array.length);
        combination(array, 0, r);
    }


    public void combination(Integer[] array, int start, int r) {
        if (r == 0) {
            for (int j = 0; j < visited.length; j++) {
                if (visited[j] == true) {
                    tmpList.add(array[j]);
                }
            }
        } else {
            for (int i = start; i < array.length; i++) {
                System.out.println("i: " + i);
                visited[i] = true;
                combination(array, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
    public void tmpListToArray() {
        int z = 0;
        for(int i = 0; i < twoArray.length; i++) {
            for(int j = 0; j < twoArray[i].length; j++) {
                twoArray[i][j] = tmpList.get(z);
                z++;
            }
        }
    }

    public static int combinationValue(int arrayLength, int r) {
        return factorial(arrayLength) / (factorial(arrayLength - r) * factorial(r));
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

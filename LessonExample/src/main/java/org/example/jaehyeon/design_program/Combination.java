package org.example.jaehyeon.design_program;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Combination {

    private final int[] array;
    private final int subSet;
    private final int setSize;

    private final List<int[]> combiList;

    public List<int[]> getCombiList() {
        return combiList;
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public Combination(int[] array, int subSet) {
        preConditionArraySize(array, subSet);
        preConditionSubSet(subSet);
        preConditionSequences(array);

        this.array = array;
        this.subSet = subSet;
        this.setSize = array.length;
        this.combiList = new ArrayList<>();
        combination();
    }

    private void combination() {
        boolean[] visited = new boolean[this.setSize];
        int start = 0;

        backTracking(visited, start, this.setSize, this.subSet);
    }

    private void backTracking(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            addCombination(visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            backTracking(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private void addCombination(boolean[] visited, int n) {
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                combination.add(this.array[i]);
            }
        }

        this.combiList.add(
                combination.stream()
                        .mapToInt(Integer::intValue)
                        .toArray());
    }


    private void preConditionArraySize(int[] array, int r) {
        if (array.length < r) {
            throw new IllegalArgumentException("배열 길이는 r 보다 크거나 같아야 한다.");
        }
    }

    private void preConditionSubSet(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("부분 집합은 0이상 이여야 한다.");
        }
    }

    private void preConditionSequences(int[] array) {
        for (int number : array) {
            if (number <= 0) {
                throw new IllegalArgumentException("sequence 들은 0보다 커야 합니다.");
            }
        }
    }
}

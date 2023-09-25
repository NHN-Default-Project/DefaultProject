package org.example.yunhwa;

import org.example.yunhwa.Math;

import java.util.ArrayList;
import java.util.List;


public class Combination<T> {

    private T[] array; // 조합할 배열
    private List<List<T>> lists; // 조합한 결과 묶음들

    // 생성자 : 조합할 배열 파라미터로 입력받아 필드들 초기화
    public Combination(T[] array) {
        this.array = array;
        lists = new ArrayList<>();
    }

    // 조합한 결과 묶음들 리턴 해주는 게터
    public List<List<T>> getLists() {
        return this.lists;
    }


    // 0. 하나의 묶음을 만들어주는 메서드
    List<T> makeOneCombi(T[] arr, boolean[] visited) {
        List<T> oneCombi = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                oneCombi.add(arr[i]);
            }
        }
        return oneCombi;
    }



    // 1. 백트래킹 활용한 조합들 만들기 메서드
    void makeCombisInArr(boolean[] visited, int start, int r) {
        if (r == 0) {
            List<T> intList = makeOneCombi(this.array, visited);
            this.lists.add(intList);
        } else {
            for (int i = start; i < this.array.length; i++) {
                visited[i] = true;
                makeCombisInArr(visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }


    // 2. 재귀 활용한 조합들 만들기 메서드
    void makeCombisInArrByRecursion(boolean[] visited, int depth, int r) {
        if (depth == this.array.length) { // 바닥에 도착했을 때
            if (r == 0) {
                List<T> intList = makeOneCombi(this.array, visited);
                this.lists.add(intList);
            } else {
                return;
            }
        } else {
            visited[depth] = true;
            makeCombisInArrByRecursion(visited, depth + 1, r - 1);

            visited[depth] = false;
            makeCombisInArrByRecursion(visited, depth + 1, r);
        }
    }

    public List<List<T>> combination(int pickCount) {
        // 조건 체크 : 나중에 junit 으로 테스트 파일 따로 만들 예정
        if (this.array.length == 0) {
            throw new IllegalArgumentException("아무 값도 입력이 되지 않았습니다.");
        }
        if (pickCount <= 0) {
            throw new IllegalArgumentException("0개 이하를 고른다는 것은 불가능한 행위입니다.");
        }
        if (this.array.length < pickCount) {
            throw new IllegalArgumentException("고르려는 개수가 고를 수 있는 개수보다 클 수가 없습니다.");
        }

        // 조합들 이차원 리스트 만들기
        makeCombisInArr(new boolean[array.length], 0, pickCount);

        return this.lists;
    }


    public void makeCombisInArrTest() {
        Integer[] arr = {1, 2, 3, 4, 5}; // 조합을 만들 배열
        boolean[] visited = new boolean[arr.length];
        int r = 2;

        Combination combination = new Combination(arr);

        // 1. 백트래킹을 이용해 구현
        System.out.println("\n------ 백트래킹 활용한 조합  ------");
        System.out.printf("%d개 중에서 %d개 뽑은 조합들 결과 %n", arr.length, r);
        combination.makeCombisInArr(visited, 0, r);
        System.out.println(combination.lists);

    }

    public void makeCombisInArrByRecursionTest() {
        Integer[] arr = {1, 2, 3, 4, 5}; // 조합을 만들 배열
        boolean[] visited = new boolean[arr.length];
        int r = 2;

        Combination combination = new Combination(arr);

        // 2. 재귀를 이용해 구현
        System.out.println("\n-------- 재귀 활용한 조합 --------");
        System.out.printf("%d개 중에서 %d개 뽑은 조합들 결과 %n", arr.length, r);
        combination.makeCombisInArrByRecursion(visited, 0, r);
        System.out.println(combination.lists);
    }
}



//    // nCr 조합 경우의 수 리턴 해주는 메서드 : n개에서 r개를 뽑는 경우의 수
//    public int combiNumOfCases(int n, int r) {
//        if (n == r || r == 0) {
//            return 1;
//        }
//
//        return combiNumOfCases(n - 1, r - 1) + combiNumOfCases(n - 1, r);
//    }
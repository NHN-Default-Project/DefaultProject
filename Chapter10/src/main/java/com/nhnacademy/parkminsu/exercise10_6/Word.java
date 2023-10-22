package com.nhnacademy.parkminsu.exercise10_6;

import java.util.TreeSet;

/**
 * 이 프로그램은 입력 파일에서 단어를 읽어와 각 단어의 출현 횟수를 세고, 그 결과를 알파벳 순서와 출현 횟수에 따라 정렬된 두 번의 출력 파일로 작성합니다.
 * 사용자는 입력 파일과 출력 파일을 지정합니다.
 * <p>
 * 이 프로그램은 Java의 일반 프로그래밍 프레임워크인 TreeMap, List 정렬, 비교자(Comparators) 등을 활용하는 몇 가지 요소를 데모합니다.
 */
public class Word {
    /**
     * 단어에 관한 필요한 데이터를 나타냅니다: 단어와 해당 단어의 출현 횟수.
     */

    private final String word;
    private int count;
    private final TreeSet<Integer> treeSet;

    public Word(String w) {
        // 새로운 단어를 만날 때 WordData 객체를 만드는 생성자.
        word = w;
        count = 1; // 출현 횟수의 초기 값은 1입니다.
        treeSet = new TreeSet<>(); //
    }
    // end class WordData


    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public TreeSet<Integer> getTreeSet() {
        return treeSet;
    }

    void setCount(int cnt) {
        this.count = cnt;
    }
} // end class WordCount

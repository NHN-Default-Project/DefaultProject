package com.nhnacademy.Jminsoo.exercise3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise9_3 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list;

        list = new CustomLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        final Iterator<Integer> originIter = list.iterator();
        final Iterator<Integer> reverseIter = list.reverse().iterator();

        //출력

        try {
            System.out.println("원본");
            while (originIter.hasNext()) {
                System.out.println(originIter.next());
            }
            System.out.println("역변환");
            while (reverseIter.hasNext()) {
                System.out.println(reverseIter.next());
            }
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println("(그럴 리는 없겠지만) next로 값을 가져올 수 없습니다!");
        }
    }
}

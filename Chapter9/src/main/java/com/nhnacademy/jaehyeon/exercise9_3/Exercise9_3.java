package com.nhnacademy.jaehyeon.exercise9_3;


public class Exercise9_3 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println(list);
        list.reverse();
        System.out.println(list);

    }
}
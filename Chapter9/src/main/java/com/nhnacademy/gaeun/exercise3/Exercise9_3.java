package com.nhnacademy.gaeun.exercise3;
/*
 * https://math.hws.edu/javanotes/c9/exercises.html
 * Write a subroutine that will make a copy of a list,
 * with the order of the items of the list reversed.
 */
public class Exercise9_3 {

    public static void main(String[] args) {

        ListNode<Integer> listNode = new ListNode<>();
        listNode.insertNode(5);
        listNode.insertNode(9);
        listNode.insertNode(2);
        listNode.insertNode(3);
        listNode.insertNode(1);
        listNode.printList();

        System.out.println("================================");
        listNode.reverse();
        listNode.printList();
    }
}
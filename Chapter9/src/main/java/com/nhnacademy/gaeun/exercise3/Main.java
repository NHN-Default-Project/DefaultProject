package com.nhnacademy.gaeun.exercise3;
//JBGW04-031
public class Main {

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
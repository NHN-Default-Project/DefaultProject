package com.nhnacademy.jaehyeon.exercise9_3;

public class ReverseList {
    public ListNode reverseCopyList(ListNode head) {
        ListNode reverseHead = null;
        while (head != null) {
            ListNode listNode = new ListNode();
            listNode.item = head.item;
            listNode.next = reverseHead;
            reverseHead = listNode;
            head = head.next;
        }
        return reverseHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }
}

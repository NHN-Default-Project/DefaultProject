package com.nhnacademy.gaeun.exercise3;
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

    static ListNode getListNode(int val) {
        return new ListNode(val);
    }
}
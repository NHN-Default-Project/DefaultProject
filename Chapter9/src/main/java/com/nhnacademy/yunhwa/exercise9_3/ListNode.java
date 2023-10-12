package com.nhnacademy.yunhwa.exercise9_3;

public class ListNode {
    int item;   // An item int the list.
    ListNode next;   // Pointer to the next node in the list.

    ListNode(int value) {
        item = value;
        next = null;
    }

    ListNode(int value, ListNode nextValue) {
        item = value;
        next = nextValue;
    }

    int getItem() {
        return item;
    }
}
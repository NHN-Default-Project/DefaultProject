package com.nhnacademy.parkminsu.exercise9_3.solution;

public class ListNode {
    int item;
    ListNode next;

    public ListNode() {
        item = 0;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item).append("\n");
        if (next != null) {
            stringBuilder.append(next);
        }
        return stringBuilder.toString();
    }
}

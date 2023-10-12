package com.nhnacademy.parkminsu.exercise9_3.generic;

public class ListNode<T> {
    T item;
    ListNode<T> next;

    public ListNode() {
        item = null;
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

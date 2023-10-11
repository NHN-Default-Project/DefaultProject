package com.nhnacademy.Jminsoo.exercise3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> {
    private static class ListNode<T> {
        T item;
        ListNode<T> next;

        public ListNode(T item) {
            this.item = item;
            this.next = null;
        }
    }

    ListNode<T> head;

    public CustomLinkedList() {
        this.head = null;
    }

    public int length() {
        int length;
        if (head == null) {
            return 0;
        } else {
            length = 1;
            ListNode<T> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                length++;
            }
        }

        return length;
    }

    public T get(int index) {
        if (index + 1 > this.length()) {
            throw new IndexOutOfBoundsException("index 범위를 초과합니다.");
        }

        ListNode<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.item;
    }

    /**
     * 값 더하기
     */
    public void add(T item) {
        ListNode<T> newNode = new ListNode<>(item);

        if (this.head == null) {
            this.head = newNode;
        } else {
            ListNode<T> tempNode = this.head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    }

    /**
     * 역순으로 출력하는 메서드
     */
    public CustomLinkedList<T> reverse() {
        if (this.head == null) {
            return new CustomLinkedList<>();
        }

        CustomLinkedList<T> tempList = new CustomLinkedList<>();

        for (int i = this.length() - 1; i >= 0; i--) {
            tempList.add(this.get(i));
        }


        return tempList;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return nextIndex < length();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(nextIndex++);

            }
        };
    }

//    private class CustomIterator implements Iterator<T> {
//        CustomLinkedList<T> customLinkedList;
//
//        public CustomIterator(CustomLinkedList<T> list) {
//            this.customLinkedList = list;
//        }
//
//
//    }
}

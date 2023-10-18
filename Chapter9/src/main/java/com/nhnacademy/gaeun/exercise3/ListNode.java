package com.nhnacademy.gaeun.exercise3;

public class ListNode<T> {
    private static class Node<T> {
        T item;
        Node next = null;

        Node(T item) {
            this.item = item;
        }
    }

    private Node<T> head;

    public ListNode() {
        this.head = null;
    }

    public void insertNode(T item) {
        if (this.head == null) {
            this.head = new Node(item);
            return;
        }
        Node runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = new Node(item);
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = this.head;
        Node next;

        while (current != null) {
            next = current.next;  // 다음 노드를 임시로 저장
            current.next = prev;  // 현재 노드의 next를 이전 노드로 설정
            prev = current;       // 이전 노드를 현재 노드로 업데이트
            current = next;       // 현재 노드를 다음 노드로 업데이트
        }
        this.head = prev;
    }

    public void printList() {
        Node<T> runner = this.head;
        if (runner == null) {
            System.out.println("ListNode가 비어있습니다.");
        }
        while (runner.next != null) {
            System.out.println(runner.item);
            runner = runner.next;
        }
        System.out.println(runner.item);
    }
}
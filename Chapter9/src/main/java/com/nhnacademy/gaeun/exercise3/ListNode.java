package com.nhnacademy.gaeun.exercise3;

public class ListNode<T> {
    protected static class Node<T> {
        protected T item;
        protected Node next = null;
        protected Node(T item) {
            this.item = item;
        }
    }
    private Node root;

    public ListNode() { this.root = null; }

    public void insertNode(T item) {
        if(this.root == null) {
            this.root = new Node(item);
            return;
        }
        Node runner = this.root;
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = new Node(item);
    }
    public void reverse() {
        Node prev = null;
        Node current = this.root;
        Node next;

        while (current != null) {
            next = current.next;  // 다음 노드를 임시로 저장
            current.next = prev;  // 현재 노드의 next를 이전 노드로 설정
            prev = current;       // 이전 노드를 현재 노드로 업데이트
            current = next;       // 현재 노드를 다음 노드로 업데이트
        }
        this.root = prev;
    }
    public void printList() {
        Node runner = this.root;
        if(runner == null) {
            System.out.println("ListNode가 비어있습니다.");
        }
        while(runner.next != null) {
            System.out.println(runner.item);
            runner = runner.next;
        }
        System.out.println(runner.item);
    }
}
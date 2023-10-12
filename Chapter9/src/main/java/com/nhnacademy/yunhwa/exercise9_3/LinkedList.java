package com.nhnacademy.yunhwa.exercise9_3;

public class LinkedList {
    ListNode head;

    // Linked List 생성자
    public LinkedList() {
        head = null; // head 노드 초기화
    }

    // 노드 삽입 (중간)
    public void insertNode(ListNode preNode, int item) {
        ListNode newNode = new ListNode(item); // 새로운 노드 생성

        // preNode - 새로운 노드 - preNode 의 원래 next
        newNode.next = preNode.next; // 새로운 노드 next 와 preNode next 를 연결
        preNode.next = newNode; // preNode 와 newNode 를 연결
    }

    // 노드 삽입 (마지막)
    public void insertNode(int item) {
        ListNode newNode = new ListNode(item); // 새로운 노드 생성
        if (head == null) { // 노드가 존재 하지 않을 때
            this.head = newNode; // head 초기화
            return;
        }
        // 1개 이상의 노드가 이미 존재할 때
        ListNode currentNode = head; // head 부터 시작해 탐색
        while (currentNode.next != null) { // 마지막 노드가 아닐 때까지
            currentNode = currentNode.next; // 계속 이동
        }
        // 현재 노드가 마지막 노드면 다음 노드로 참조
        currentNode.next = newNode;
    }

    public LinkedList reverseList() {
        LinkedList reversedList = new LinkedList();

        ListNode nextNode = head;
        ListNode currentNode = null;
        ListNode preNode = null;

        while (nextNode != null) { // 끝 노드가 아닐 때까지
            preNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;
            currentNode.next = preNode;
        }
        // 끝 노드를 head 로
        reversedList.head = currentNode;

        return reversedList;
    }

    public void printList() {
        System.out.println(toString());
    }

    public String toString() {
        ListNode currentNode = head;
        StringBuilder sb = new StringBuilder();

        while (currentNode.next != null) {
            sb.append(String.format("%d - ", currentNode.item));
            currentNode = currentNode.next;
        }
        sb.append(String.format("%d%n", currentNode.item));

        return sb.toString();
    }
}

package com.nhnacademy.yunhwa.exercise9_3;

public class LinkedList {
    private static class ListNode {

        int item;
        ListNode next;

        ListNode(int value) {
            item = value;
            next = null;
        }

        ListNode(int value, ListNode nextValue) {
            item = value;
            next = nextValue;
        }
    }

    ListNode head;
    ListNode tail;

    // Linked List 생성자
    public LinkedList() {
        head = null; // head 노드 초기화
        tail = null; // tail 노드 초기화
    }

    // 노드 삽입 (중간)
    public void insertNode(ListNode preNode, int item) {
        if (preNode == null) { // preNode가 null인 경우 head에 삽입
            insertHead(item);
            return;
        }

        ListNode newNode = new ListNode(item); // 새로운 노드 생성

        // preNode - 새로운 노드 - preNode 의 원래 next
        newNode.next = preNode.next; // 새로운 노드 next 와 preNode next 를 연결
        preNode.next = newNode; // preNode 와 newNode 를 연결

        if (preNode == tail) { // 만약 preNode가 tail인 경우 tail 업데이트
            tail = newNode;
        }
    }

    private void insertHead(int item) {
        ListNode newNode = new ListNode(item); // 새로운 노드 생성

        if (head == null) { // 리스트가 비어있는 경우, head 와 tail 을 모두 업데이트
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head; // 기존의 헤드를 다음 노드로 설정
        head = newNode; // 새로운 노드를 헤드로 업데이트
    }

    // 노드 삽입 (마지막)
    public void insertTail(int item) {
        ListNode newNode = new ListNode(item); // 새로운 노드 생성
        if (tail == null) {
            if (head == null) { // 노드가 존재 하지 않을 때
                head = newNode; // head 초기화
                tail = newNode; // tail 초기화
            }
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void setTail() {
        if (head == null) {
            tail = null;
            return;
        }

        // 1개 이상의 노드가 이미 존재할 때
        ListNode currentNode = head; // head 부터 시작해 탐색
        while (currentNode.next != null) { // 마지막 노드가 아닐 때까지
            currentNode = currentNode.next; // 계속 이동
        }
        // 현재 노드가 마지막 노드 : tail 업데이트
        tail = currentNode;
    }

    public LinkedList reverseList() {
        LinkedList reversedList = new LinkedList();

        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        // 끝 노드를 head 로
        reversedList.head = tail;

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

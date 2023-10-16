package com.nhnacademy.parkminsu.exercise9_3;

public class CustomLinkedList<T> {
    ListNode<T> listNode;
    private int size = 0;

    public void add(T item) {
        ListNode<T> newListNode = new ListNode<>();
        newListNode.item = item;
        this.listNode = addListNode(this.listNode, newListNode);

    }

    private ListNode<T> addListNode(ListNode<T> listNode, ListNode<T> newListNode) {
        if (listNode == null) {
            this.size++;
            return newListNode;
        }
        listNode.next = addListNode(listNode.next, newListNode);
        return listNode;
    }

    public CustomLinkedList<T> reverse() {
        CustomLinkedList<T> customLinkedList = new CustomLinkedList<>();
        customLinkedList = reverse(customLinkedList, this.listNode, 0);
        return customLinkedList;
    }

    private CustomLinkedList<T> reverse(CustomLinkedList<T> customLinkedList, ListNode<T> listNode, int size) {
        int sizeNum = size;
        if (sizeNum == this.size) {
            return customLinkedList;
        }
        sizeNum = sizeNum + 1;
        reverse(customLinkedList, listNode.next, sizeNum);
        customLinkedList.add(listNode.item);
        return customLinkedList;
    }

    public T get(int index) {
        isCheckElementIndex(index);
        return node(index).item;
    }

    private ListNode<T> node(int index) {
        ListNode<T> node = this.listNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;

    }

    private void isCheckElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("인덱스의 범위를 넘었습니다");
        }
    }

    private boolean isElementIndex(int index) {
        return index < this.size && index >= 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "" + listNode + "\n";
    }


    private static class ListNode<T> {
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

}

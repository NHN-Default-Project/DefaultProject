package com.nhnacademy.parkminsu.exercise9_3.generic;

import java.util.List;

public class ReversLinkedList<T> {
    ListNode<T> listNode;
    private int listSize = 0;

    public void add(T item) {
        ListNode<T> newListNode = new ListNode();
        newListNode.item = item;
        if (this.listNode == null) {
            this.listNode = newListNode;
        } else {
            this.listNode = addListNode(this.listNode, newListNode);
        }
    }

    private ListNode<T> addListNode(ListNode<T> listNode, ListNode<T> newListNode) {
        if (listNode == null) {
            return newListNode;
        }

        listNode.next = addListNode(listNode.next, newListNode);
        return listNode;
    }

    public void makeReverseLinkedList(ReversLinkedList<T> reversLinkedList, List<T> list) {
        int sizeNum = listSize;
        if (list.size() == listSize) {
            return;
        }
        listSize++;
        makeReverseLinkedList(reversLinkedList, list);
        reversLinkedList.add(list.get(sizeNum));
    }


    @Override
    public String toString() {
        return "" + listNode + "\n";
    }
}

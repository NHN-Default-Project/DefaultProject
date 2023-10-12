package com.nhnacademy.parkminsu.exercise9_3.solution;

import java.util.List;

public class ReversLinkedList {
    ListNode listNode;
    private int listSize = 0;

    public void add(int item) {
        ListNode newListNode = new ListNode();
        newListNode.item = item;
        if (this.listNode == null) {
            this.listNode = newListNode;
        } else {
            this.listNode = addListNode(this.listNode, newListNode);
        }
    }

    private ListNode addListNode(ListNode listNode, ListNode newListNode) {
        if (listNode == null) {
            return newListNode;
        }

        listNode.next = addListNode(listNode.next, newListNode);
        return listNode;
    }

    public void makeReverseLinkedList(ReversLinkedList reversLinkedList, List<Integer> list) {
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

    private class ListNode {
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

}

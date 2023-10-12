package com.nhnacademy.gaeun.exercise3;
//JBGW04-031
public class Main {

    public static void main(String[] args) {

        ListNode listNode1 = ListNode.getListNode(1);
        ListNode listNode2 = ListNode.getListNode(2);
        ListNode listNode3 = ListNode.getListNode(3);
        ListNode listNode4 = ListNode.getListNode(4);
        ListNode listNode5 = ListNode.getListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution solution = new Solution();
        solution.reverseOrder(listNode1);
    }
}

class Solution {
    public ListNode reverseOrder(ListNode head) {

        ListNode prePrevNode = null;
        ListNode prevNode = head;
        ListNode curNode = head.next;

        System.out.println("## Origin Linked List");
        printNode(head);

        System.out.println("## Reverse Linked List Order");
        prevNode = getReverseOrderListHeadNode(prePrevNode, prevNode, curNode);
        printNode(prevNode);

        head = prevNode;

        prePrevNode = null;
        prevNode = head;
        curNode = head.next;

        System.out.println("## Reverse Linked List Order");
        prevNode = getReverseOrderListHeadNode(prePrevNode, prevNode, curNode);
        printNode(prevNode);

        return head;
    }

    private ListNode getReverseOrderListHeadNode(ListNode prePrevNode, ListNode prevNode, ListNode curNode) {
        ListNode nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            prevNode.next = prePrevNode;
            curNode.next = prevNode;

            prePrevNode = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

    private void printNode(ListNode prevNode) {
        ListNode printNode = prevNode;
        while (printNode != null) {
            System.out.println(printNode.val);
            printNode = printNode.next;
        }
        System.out.println();
    }
}
package org.leetcode.linklist;

import org.leetcode.utils.NodeUtils;

public class SwapNodesInPairs_24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode listNode = new SwapNodesInPairs_24().swapPairs(node1);
        NodeUtils.printNode(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode previous = helper;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            if (next != null) {
                current.next = next.next;
                previous.next = next;
                next.next = current;
                previous = previous.next.next;
                current = current.next;
            } else {
                current = current.next;
            }
        }

        return helper.next;
    }
}


package org.others.linklist;

import org.leetcode.linklist.ListNode;

public class ReverseLinkList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        new ReverseLinkList().reverse(node1);
    }

    /**
     * 递归反转链表
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

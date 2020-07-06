package org.leetcode.linklist;

import org.leetcode.utils.NodeUtils;

public class ReverseKGroup_25 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        NodeUtils.printNodeWithOneLine(new ReverseKGroup_25().reverseKGroup(node1,3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (k == cnt) {
            ListNode next = reverseKGroup(cur, k);
            while (cnt-- > 0) {
                ListNode tmp = head.next;
                head.next = next;
                next = head;
                head = tmp;
            }
            return next;
        }
        return head;
    }

    /**
     * 反转所有数据
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}

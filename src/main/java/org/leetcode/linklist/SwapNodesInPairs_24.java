package org.leetcode.linklist;

public class SwapNodesInPairs_24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head ==null || head.next ==null) return head;
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


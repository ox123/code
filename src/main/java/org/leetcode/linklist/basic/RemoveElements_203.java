package org.leetcode.linklist.basic;

import org.leetcode.linklist.ListNode;
import org.leetcode.utils.NodeUtils;

public class RemoveElements_203 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = NodeUtils.generateNodeList(arr);
        ListNode listNode1 = new RemoveElements_203().removeElements(listNode, 6);
        NodeUtils.printNodeWithOneLine(listNode1);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode p = helper;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return helper.next;
    }
}

package org.leetcode.linklist;

import org.leetcode.utils.Utils;
import org.leetcode.utils.NodeUtils;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNums_2 {
    public static void main(String[] args) {
        int[] array = Utils.getUniqueArray(5);
        int[] array1 = Utils.getUniqueArray(5);
        ListNode listNode = NodeUtils.generateNodeList(array);
        ListNode listNode1 = NodeUtils.generateNodeList(array1);
        NodeUtils.printNodeWithOneLine(new AddTwoNums_2().addTwoNumbers(listNode1, listNode));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum >= 10 ? 1 : 0;
            head.next = new ListNode(sum % 10);
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) head.next = new ListNode(1);
        return result.next;
    }
}

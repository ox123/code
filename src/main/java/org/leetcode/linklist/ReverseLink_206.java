package org.leetcode.linklist;

import org.leetcode.utils.Utils;
import org.leetcode.utils.NodeUtils;

import java.util.Arrays;

/**
 * TODO 多次理解 反转链表
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 */
public class ReverseLink_206 {
    public static void main(String[] args) {
        int[] array = Utils.getUniqueArray(10);
        System.out.println(Arrays.toString(array));
        int[] nums = {1, 3, 4, 5};
        ListNode nodeList = NodeUtils.generateNodeList(nums);
        NodeUtils.printNodeWithOneLine(new ReverseLink_206().reverseWithRecurse(nodeList));
    }

    public ListNode reverseWithRecurse(ListNode node){
        if (node.next == null){
            return node;
        }
        ListNode newHead = reverseWithRecurse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public ListNode reverserNodeList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            // 如下三步理解
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

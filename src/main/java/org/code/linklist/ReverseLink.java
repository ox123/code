package org.code.linklist;

import org.code.sort.Utils;
import org.code.utils.NodeUtils;

import java.util.Arrays;

/**
 * TODO 多次理解 反转链表
 */
public class ReverseLink {
    public static void main(String[] args) {
        int[] array = Utils.getUniqueArray(10);
        System.out.println(Arrays.toString(array));
        int[] nums = {1, 3, 4, 5};
        ListNode nodeList = NodeUtils.generateNodeList(nums);
        NodeUtils.printNodeWithOneLine(new ReverseLink().reverserNodeList(nodeList));
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

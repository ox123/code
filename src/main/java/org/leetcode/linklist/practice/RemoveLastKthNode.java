package org.leetcode.linklist.practice;

import org.leetcode.linklist.ListNode;
import org.leetcode.utils.Utils;
import org.leetcode.utils.NodeUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 快慢指针实现：https://blog.csdn.net/LiuBo_01/article/details/80341377
 */
public class RemoveLastKthNode {
    public static void main(String[] args) {
        int[] array = Utils.getArray(10);
        System.out.println(Arrays.toString(array));
        ListNode listNode = NodeUtils.generateNodeList(array);
        ListNode listNode1 = new RemoveLastKthNode().removeLastKthNodeWithSlowFast(listNode, 3);
        List<Integer> integers = NodeUtils.returnWithList(listNode1);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public ListNode removeLastKthNode(ListNode head, int k) {
        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * TODO 待修改为正确版本
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode removeLastKthNodeWithSlowFast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            k--;
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

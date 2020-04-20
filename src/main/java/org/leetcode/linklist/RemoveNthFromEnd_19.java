package org.leetcode.linklist;

import org.leetcode.utils.NodeUtils;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        ListNode listNode = new RemoveNthFromEnd_19().removeNthFromEnd1(listNode1, 1);
        NodeUtils.printNode(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (n == length)
            return head.next;
        p = head;
        for (int i = 1; i < length - n; i++)
            p = p.next;
        if (p.next.next != null)
            p.next = p.next.next;
        else
            p.next = null;
        return head;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        int count = 0;

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            count++;
            slow = slow.next;
        }
        // 判断删除最后一个数据
        if (count == n) {
            return temp.next;
        }
        slow = head;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }

    /**
     * fail method
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode k = head;
        int length = 0;
        while (k != null) {
            length++;
            k = k.next;
        }
        if (n == length)
            return head.next;
        ListNode res = head;
        ListNode p = head;
        ListNode q = head;
        int count = 0;
        while (p.next != null) {
            count++;
            if (count <= n) {
                p = p.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        // 删除最后一个节点
        while (p.next.next != null) {
            p.val = p.next.val;
            p = p.next;
        }
        q.val = q.next.val;
        return res;
    }
}

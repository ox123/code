package org.leetcode.linklist;

/**
 * https://leetcode.com/problems/trapping-rain-water/solution/
 */
public class PalindromeLinkedList_232 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(1);
        node1.next = node2;
//        node2.next = node3;
        ListNode node = node1;
//        ListNode header = new ListNode(0);
//        // reverse the link list
//        while (node != null && node.val > 0) {
//            System.out.println(node.val);
//
//            ListNode item = new ListNode(node.val);
//            ListNode tmp = header.next;
//            header.next = item;
//            item.next = tmp;
//
//            node = node.next;
//        }
//        while (header != null && header.next != null) {
//            ListNode item = header.next;
//            System.out.println(item.val);
//            header = header.next;
//        }
        System.out.println(new PalindromeLinkedList_232().isPalindrome(node));

    }

    public ListNode reversNodeList(ListNode node) {
        ListNode header = new ListNode(Integer.MAX_VALUE);
        while (node != null && node.val != Integer.MAX_VALUE) {
            ListNode item = new ListNode(node.val);
            ListNode tmp = header.next;
            header.next = item;
            item.next = tmp;
            node = node.next;
        }
        return header;
    }

    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        ListNode reversedList = reversNodeList(head);
        while (head != null && head.next != null) {
            if (head.val != reversedList.next.val) {
                return false;
            }
            head = head.next;
            reversedList = reversedList.next;
        }
        return result;
    }
}

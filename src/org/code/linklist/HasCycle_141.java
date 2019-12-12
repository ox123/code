package org.code.linklist;

public class HasCycle_141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        boolean flag = false;
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}

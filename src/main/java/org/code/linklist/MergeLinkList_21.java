package org.code.linklist;

public class MergeLinkList_21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            }else {
                head.next = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            head = head.next;
        }
        res.next = l1.next != null ? l1 : l2;
        return res.next;
    }
}

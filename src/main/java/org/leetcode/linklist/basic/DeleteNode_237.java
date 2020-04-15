package org.leetcode.linklist.basic;

import org.leetcode.linklist.ListNode;

public class DeleteNode_237 {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode1(ListNode node) {
       while(node.next.next !=null){
           node.val = node.next.val;
           node = node.next;
       }
       node.val = node.next.val;
       node.next = null;
    }
}

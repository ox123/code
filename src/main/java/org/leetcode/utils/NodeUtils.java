package org.leetcode.utils;

import org.leetcode.linklist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeUtils {

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void printNodeWithOneLine(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    public static List<Integer> returnWithList(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList;
    }

    public static ListNode generateNodeList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            head.next = tmp;
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        ListNode nodeList = generateNodeList(nums);
        printNode(nodeList);
        printNodeWithOneLine(nodeList);
    }
}

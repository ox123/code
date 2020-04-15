package org.leetcode.str;

import java.util.*;

public class SlideWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 4};
        String s = "abcabcab";
        System.out.println(Arrays.toString(new SlideWindow().maxSlidingWindow(nums,2)));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) return new int[0];
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> dequeList = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            if (!dequeList.isEmpty() && dequeList.getFirst() == i - k) {
                dequeList.removeFirst();
            }
            while (!dequeList.isEmpty() && nums[dequeList.getLast()] < nums[i]) {
                dequeList.removeLast();
            }
            dequeList.addLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dequeList.getFirst()];
            }
        }
        return res;
    }
}

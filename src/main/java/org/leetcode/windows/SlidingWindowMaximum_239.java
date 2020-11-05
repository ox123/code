package org.leetcode.windows;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new SlidingWindowMaximum_239().maxSlidingWindow(nums,3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) return null;
        int length = nums.length;
        int res[] = new int[length - k + 1];
        int index = 0;
        LinkedList<Integer> window = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            window.addLast(i);
            if (window.peekFirst() == i - k) {
                window.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[window.peekFirst()];
            }
        }
        return res;
    }
}

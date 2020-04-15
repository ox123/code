package org.leetcode.search;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement_162 {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 1};
        System.out.println(new FindPeakElement_162().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int num = 0, length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[middle+1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }

    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
        }
        return -1;
    }
}

package org.leetcode.search;

/**
 * https://leetcode.com/problems/binary-search/
 * TODO
 */
public class BinarySearch_704 {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12};
        System.out.println(new BinarySearch_704().search(nums, 9));
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int i = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search1(int[] arr, int t) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] >= t) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == t) return l;
        return -1;
    }
}

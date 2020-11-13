package org.leetcode.str;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays_4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{4};
        System.out.println(new FindMedianSortedArrays_4().findMedianSortedArrays1(nums1, nums2));
    }


    /**
     * Runtime: 3 ms, faster than 30.46% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 47.2 MB, less than 86.11% of Java online submissions for Median of Two Sorted Arrays.
     * <p>
     * 时间复杂度：o(nlog(n))
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] arr = new int[length];
        for (int i = 0; i < length1; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i < length2; i++) {
            arr[i + length1] = nums2[i];
        }
        Arrays.sort(arr);
        int flag = length % 2;
        if (flag == 0) {
            return (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
        } else {
            return arr[length / 2];
        }
    }

    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 47.3 MB, less than 84.03% of Java online submissions for Median of Two Sorted Arrays
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int arr[] = new int[length];
        int i = 0, j = 0, k = 0;
        while (i < length1 & j < length2) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < length1) {
            arr[k++] = nums1[i++];
        }
        while (j < length2) {
            arr[k++] = nums2[j++];
        }
        int flag = length % 2;
        if (flag == 0) {
            return (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
        } else {
            return arr[length / 2];
        }
    }
}

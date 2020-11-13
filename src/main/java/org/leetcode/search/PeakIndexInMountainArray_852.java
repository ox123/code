package org.leetcode.search;

/**
 * TODO https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInMountainArray_852 {
    public static void main(String[] args) {
        int A[] = new int[]{0, 2, 1, 0};
        System.out.println(new PeakIndexInMountainArray_852().peakIndexInMountainArray(A));
    }

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i + 1 < A.length && A[i + 1] < A[i])
                return i;
        }
        return 0;
    }
}

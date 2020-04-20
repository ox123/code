package org.leetcode.dynamic;

/**
 * TODO
 * <p>
 * 1. 使用滑动窗口解答
 * <p>
 * <p/>
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class LongestMountain_845 {
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(new LongestMountain_845().longestMountain(A));
    }

    public int longestMountain(int[] A) {
        int upstart = -1;
        boolean firstup = true;
        int ans = 0;
        int n = A.length;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                if (firstup) {
                    upstart = i - 1;
                    firstup = false;
                }
            } else if (A[i] == A[i - 1]) {
                upstart = -1;
                firstup = true;
            } else {
                if (upstart > -1) {
                    ans = Math.max(ans, (i - upstart + 1));
                }
                firstup = true;
            }
        }
        return ans;
    }
}

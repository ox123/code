package org.code.str;

import java.util.List;

public class MinTreePath {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        System.out.println(new int[0]);
        int[] nums = new int[]{7, 2, 4};
        String s = "abcabcab";
//        System.out.println(Arrays.toString(new SlideWindow().maxSlidingWindow(nums, 2)));
        System.out.println(new SlideWindow().lengthOfLongestSubstring(s));
        int n = 3;
        for (int i = 0; i < n; ++i) {
            System.out.print(i);
        }
    }

    /**
     * https://leetcode.com/problems/triangle/
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int dp[][] = new int[row][row];
        List<Integer> lastRow = triangle.get(row - 1);
        for (int i = 0; i < row; i++) {
            dp[row - 1][i] = lastRow.get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            List<Integer> item = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + item.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * https://leetcode.com/problems/maximum-subarray/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    int get_MaxSum(int arr[], int col) {
        int max_sum = 0, tmp = 0;
        for (int i = 0; i < col; i++) {
            tmp = Math.max(tmp, 0) + arr[i];
            max_sum = Math.max(tmp, max_sum);
        }
        return max_sum;
    }
}

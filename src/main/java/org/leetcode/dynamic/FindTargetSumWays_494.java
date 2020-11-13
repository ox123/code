package org.leetcode.dynamic;

import java.util.Arrays;

public class FindTargetSumWays_494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new FindTargetSumWays_494().findTargetSumWays(nums, S));
    }

    /**
     * 使用0-1背包方式, TODO 理解
     * <p>
     * 参考：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     */
    public int findTargetSumWays(int[] nums, int S) {
//        使用dfs方式
//        calculate(nums, 0, 0, S);
        int sum = 0;
        for (int x :
                nums) {
            sum += x;
        }
        if ((S + sum) % 2 == 1 || S > sum) return 0;
        S = (S + sum) >> 1;
        int[] dp = new int[S + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int x :
                nums) {
            for (int i = S; i >= x; i--) {
                dp[i] += dp[i - x];
            }
        }
        int ans = dp[S];
        return ans;
    }

    /**
     * 递归解法
     */
    int count = 0;

    public int findTargetSumWays1(int[] nums, int S) {
//        calculate(nums, 0, 0, S);
//        return count;
        // dfs方法
        return dfs(nums, S, 0);
    }

    public int dfs(int[] nums, int target, int left) {
        if (target == 0 && left == nums.length) {
            return 1;
        }
        if (left >= nums.length) return 0;
        int ans = 0;
        ans += dfs(nums, target - nums[left], left + 1);
        ans += dfs(nums, target + nums[left], left + 1);
        return ans;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum - nums[i], S);
            calculate(nums, i + 1, sum + nums[i], S);
        }
    }
}

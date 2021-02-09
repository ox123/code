package org.leetcode.dynamic;

/**
 * TODO
 * 1. https://leetcode.com/problems/house-robber-ii/discuss/1003154/Easy-to-understand-Java-code-O(n)-approach
 *
 */
public class HouseRobber_213 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new HouseRobber_213().rob(nums));
    }

    public int rob(int[] nums) {
        int res = 0;
        if (nums == null || nums.length < 3) {
            return res;
        }
        return res;
    }
}

package org.leetcode.array;

import java.util.Arrays;

public class ArrayPairSum_561 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(new ArrayPairSum_561().arrayPairSum(nums));

    }

    /**
     * TODO 理解+2 原因, 获取偶数index值即可
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}

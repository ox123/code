package org.code.bit;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 4, 4};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

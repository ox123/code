package org.code.str;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int nums[] = new int[]{0,1,0,3,12};
        new MoveZeroes_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num :
                nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index< nums.length){
            nums[index++] = 0;
        }
    }
}

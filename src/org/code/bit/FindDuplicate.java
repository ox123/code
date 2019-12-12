package org.code.bit;

/**
 * TODO https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,4,2,2};
        System.out.println(new FindDuplicate().findDuplicate(arr));
    }
    public int findDuplicate(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}

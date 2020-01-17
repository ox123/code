package org.code.str;

/**
 * TODO hard level
 * good solution: https://leetcode.com/problems/reverse-pairs/discuss/338550/Java-Binary-Indexed-Tree
 * segement tree:https://leetcode.com/problems/reverse-pairs/discuss/298986/Java-segment-tree
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 2, 3, 1};
        int[] nums = new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(new ReversePairs().reversePairs(nums1));
        System.out.println(2147483647 * 2);
    }

    /**
     * 超出十进制位数,异常. ugly
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (i < j && nums[i] > 2 * nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}

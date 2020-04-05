package org.code.array;

public class SmallerNumbersThanCurrent_1365 {
    public static void main(String[] args) {

    }

    /**
     * 暴力破解
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int tmp = 0;
            for (int j = 0; j < length; j++) {
                if (nums[i] > nums[j] && i != j) {
                    ++tmp;
                }
            }
            res[i] = tmp;
        }
        return res;
    }
}

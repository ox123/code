package org.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class SmallerNumbersThanCurrent_1365 {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度为: nlog(n),空间复杂度： o(n)
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] help = nums.clone();
        int[] res = new int[length];
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
//            if (map.containsKey(nums[i])) continue;
////            else map.put(nums[i], i);
            map.putIfAbsent(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            res[i] = map.get(help[i]);
        }
        return res;
    }

    /**
     * 暴力破解 o(n^2)
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
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

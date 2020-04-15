package org.leetcode.array;

import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 可以找到更优解
 */
public class CountSmaller_315 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(Arrays.toString(new CountSmaller_315().countSmaller(nums).toArray()));
        System.out.println(Arrays.toString(((URLClassLoader)CountSmaller_315.class.getClassLoader()).getURLs()));
    }

    /**
     * Runtime: 621 ms, faster than 22.89% of Java online submissions for Count of Smaller Numbers After Self.
     * Memory Usage: 42.1 MB, less than 5.55% of Java online submissions for Count of Smaller Numbers After Self.
     * 暴力破解，复杂度太高
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int tmp = 0;
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    ++tmp;
                }
            }
            res.add(tmp);
        }
        return res;
    }
}

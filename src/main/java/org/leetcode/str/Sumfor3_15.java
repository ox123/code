package org.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 也许与更优解法
 * https://leetcode.com/problems/3sum/submissions/
 */
public class Sumfor3_15 {
    public static void main(String[] args) {
//        int num[] = new int[]{-1, 0, 1, 2, -1, -4};
//        int num[] = new int[]{1, 1, 1};
        int num[] = new int[]{-2, 0, 0, 2, 2};
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
//        System.out.println(Arrays.toString(new Sumfor3_15().threeSum(num).toArray()));
        List<List<Integer>> tmp = new Sumfor3_15().threeSum(num);
        System.out.println("----" + tmp);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        System.out.println(result);
    }

    /**
     * Runtime: 32 ms, faster than 65.05% of Java online submissions for 3Sum.
     * Memory Usage: 46.2 MB, less than 92.93% of Java online submissions for 3Sum.
     * 时间复杂度: o(n^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            // 去除重复部分值
            if (i > 0) {
                while (i < length - 2 && nums[i - 1] == nums[i]) continue;
            }
            // 排序之后第一个数值大于0，则一定不存在这样的元组
            if (nums[i] > 0) return result;
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List tmp = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
//                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    if (!result.contains(tmp)) {
                        result.add(tmp);
                    }
                    left++;
                    right--;
                    // 两个while循环过滤重复的值，如果没有此两个过滤条件，结果可能出现重复的值。此种方式结果更好
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

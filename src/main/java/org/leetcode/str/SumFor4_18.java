package org.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class SumFor4_18 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(new SumFor4_18().fourSum(nums, 0));
    }

    /**
     * Runtime: 16 ms, faster than 75.61% of Java online submissions for 4Sum.
     * Memory Usage: 40.2 MB, less than 53.62% of Java online submissions for 4Sum.
     * TODO 时间复杂度和空间复杂度有待提升
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<Integer> tmp;
        for (int i = 0; i < length - 3; ++i) {
            for (int j = i + 1; j < length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        tmp = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        ++l;
                        --r;
                        if (!result.contains(tmp)) {
                            result.add(tmp);
                        }
                    } else if (sum < target) {
                        ++l;
                    } else {
                        --r;
                    }
                }
            }
        }
        return result;
    }
}

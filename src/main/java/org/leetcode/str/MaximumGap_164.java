package org.leetcode.str;

import java.util.Arrays;

/**
 * 1 https://leetcode.com/problems/maximum-gap/discuss/50669/Beat-99.81-java-coder o(n)复杂度
 */
public class MaximumGap_164 {
    public static void main(String[] args) {
//        int num[] = new int[]{3, 6, 9, 1};
        int num[] = new int[]{1, 3, 100};
        System.out.println(new MaximumGap_164().maximumGap(num));
    }

    /**
     * Runtime: 3 ms, faster than 78.86% of Java online submissions for Maximum Gap.
     * Memory Usage: 37.6 MB, less than 89.66% of Java online submissions for Maximum Gap.
     * TODO ugly 时间复杂度
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums == null | nums.length < 2) return 0;
        int result = 0;
        Arrays.sort(nums);
        int length = nums.length;
        if (length == 2) return nums[1] - nums[0];
        for (int i = 1; i < length; i++) {
            result = Math.max(nums[i] - nums[i - 1], result);
        }
        return result;
    }

    /**
     * TODO 仔细分析 https://leetcode.com/problems/maximum-gap/discuss/50669/Beat-99.81-java-coder
     *
     * @param nums
     * @return
     */
    public int maximumGap1(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (min > nums[i]) min = nums[i];
            if (max < nums[i]) max = nums[i];
        }

        int gap = (max - min) / (n - 1);
        if (gap == 0) gap++;
        int len = (max - min) / gap + 1;
        int[] tmax = new int[len];
        int[] tmin = new int[len];

        for (int i = 0; i < n; i++) {
            int index = (nums[i] - min) / gap;
            if (nums[i] > tmax[index]) tmax[index] = nums[i];
            if (tmin[index] == 0 || nums[i] < tmin[index]) tmin[index] = nums[i];
        }
        int myMax = 0;
        for (int i = 0; i < len; i++) {
            if (myMax < tmin[i] - min) myMax = tmin[i] - min;
            if (tmax[i] != 0) min = tmax[i];
        }
        return myMax;
    }
}

package org.leetcode.str;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class FindErrorNums_645 {
    public static void main(String[] args) {
        int []nums = {1,2,2,4};
        System.out.println(Arrays.toString(new FindErrorNums_645().findErrorNums(nums)));
    }
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int dumplicate = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            if (set.contains(num)) {
                dumplicate = num;
                res[0] = dumplicate;
            } else {
                set.add(num);
                sum -= num;
            }
        }
        res[1] = sum;
        return res;
    }
}

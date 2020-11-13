package org.leetcode.str;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber_179 {
    public static void main(String[] args) {
//        int [] arr =  new int[]{10,2};
        int[] arr = new int[]{3, 30, 34, 5, 9};
//        int[] arr = new int[]{0, 0};
        System.out.println(new LargestNumber_179().largestNumber(arr));
    }

    /**
     * Runtime: 3 ms, faster than 99.26% of Java online submissions for Largest Number.
     * Memory Usage: 36 MB, less than 82.22% of Java online submissions for Largest Number.
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String arr[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String aa = s + t1;
                String bb = t1 + s;
                return bb.compareTo(aa);
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String item :
                arr) {
            builder.append(item);
        }
        String result = builder.toString();
        if (result.startsWith("0")) {
            return "0";
        }
        return builder.toString();
    }
}

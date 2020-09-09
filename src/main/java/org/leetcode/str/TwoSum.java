package org.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 2, 3};
        int num = 4;
        System.out.println(new TwoSum().twoSumTarget(arr, num));

    }

    public List<List<Integer>> twoSumTarget(int[] arr, int num) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int lo = arr[left], hi = arr[right];
            int target = arr[left] + arr[right];
            if (target < num) {
                left++;
            } else if (target > num) {
                right--;
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[left]);
                tmp.add(arr[right]);
                res.add(tmp);
                while (left < right && lo == arr[left]) left++;
                while (left < right && hi == arr[right]) right--;
            }
        }
        return res;
    }
}

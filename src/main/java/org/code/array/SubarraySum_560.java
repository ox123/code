package org.code.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {
    public static void main(String[] args) {
        int[] nums = {};
        int k = 0;
        System.out.println(new SubarraySum_560().subarraySum(nums, k));
    }

    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < length; i++) {
            if (sum[i] == k) ++result;
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] == k) ++result;
            }
        }
        return result;
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}

package org.code.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 4, 2, 2};
        System.out.println(new FindDuplicate().findDuplicate(arr));
    }

    /**
     * Ugly way
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() > 1) {
                num = entry.getKey();
                break;
            }
        }
        return num;
    }

    public int findDuplicate1(int[] nums) {
        int arr[] = new int[nums.length];
        for (int item :
                nums) {
            ++arr[item];
            if (arr[item] > 1) {
                return item;
            }
        }
        return -1;
    }
}

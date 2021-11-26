package org.leetcode.str;

import java.util.HashMap;

public class FindSpecialInteger_1287 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
//        int specialInteger = new FindSpecialInteger_1287().findSpecialInteger(arr);
        int specialInteger = new FindSpecialInteger_1287().find(arr);
        System.out.println(specialInteger);
    }

    public int find(int[] arr) {
        int len = arr.length;
        int limit = len / 4;
        for (int i = 0; i < len; i++) {
            if (arr[i] == arr[i+limit]){
                return arr[i];
            }
        }
        return -1;
    }

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            if (map.get(arr[i]) > max) {
                max = map.get(arr[i]);
                result = arr[i];
            }
        }
        return result;
    }
}

package org.leetcode.str;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII_350 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 2);
        System.out.println(map.getOrDefault(1, 0) + 1);
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII_350().intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<Integer>();

        for (int x :
                nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        AtomicInteger i = new AtomicInteger();
        for (int y :
                nums2) {
            if (map.getOrDefault(y, 0) > 0) {
                list.add(y);
                map.put(y, map.get(y) - 1);
            }
        }
        int size = list.size();
        int[] res = new int[list.size()];
        list.forEach((val) -> {
            res[i.getAndIncrement()] = val;
        });
        return res;
    }
}

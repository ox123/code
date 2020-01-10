package org.code.str;

import java.util.*;

public class SlideWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 4};
        String s = "abcabcab";
        System.out.println(new SlideWindow().lengthOfLongestSubstring(s));
        int n = 3;
        for (int i = 0; i < n; ++i) {
            System.out.print(i);
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) return new int[0];
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> dequeList = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            if (!dequeList.isEmpty() && dequeList.getFirst() == i - k) {
                dequeList.removeFirst();
            }
            while (!dequeList.isEmpty() && nums[dequeList.getLast()] < nums[i]) {
                dequeList.removeLast();
            }
            dequeList.addLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dequeList.getFirst()];
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char item = s.charAt(i);
            if (map.containsKey(item)) {
                j = Math.max(j, map.get(item) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}

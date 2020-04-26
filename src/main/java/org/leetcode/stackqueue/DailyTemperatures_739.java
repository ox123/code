package org.leetcode.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(new DailyTemperatures_739().dailyTemperatures(nums));
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek()){
                int x =  stack.pop();
                res[x] = i-x;
            }
            stack.push(i);
        }
        return res;
    }
    /**
     * 暴力解法
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        Arrays.fill(res, 0);
        for (int i = 0; i < length; i++) {
            int current = T[i];
            for (int j = i + 1; j < length; j++) {
                if (T[j] > current) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}

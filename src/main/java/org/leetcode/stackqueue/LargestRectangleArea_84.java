package org.leetcode.stackqueue;

import java.util.Stack;

public class LargestRectangleArea_84 {
    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {6, 4, 5, 2, 4, 3, 9};
        int[] test = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleArea_84().largestRectangleArea(heights));
        System.out.println(new LargestRectangleArea_84().largestRectangleAreaWithStack(test));
    }

    /**
     * 时间复杂度： O(n^2)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxAre = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {
                minHeight = Math.min(heights[j], minHeight);
                maxAre = Math.max(maxAre, minHeight * (j - i + 1));
            }
        }
        return maxAre;
    }

    public int largestRectangleAreaWithStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, heights[prev] * i);
                } else {
                    // i- stack.peek()-1 理解重点
                    ans = Math.max(ans, heights[prev] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return ans;
    }

}

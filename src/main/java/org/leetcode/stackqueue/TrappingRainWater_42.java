package org.leetcode.stackqueue;

import java.util.Stack;

/**
 * 详细解析：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 */
public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater_42().trap(height));
    }

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                res = res + distance * (min - h);
            }
            stack.push(height[current]);
            current++;
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        for (int i = 1; i < length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 0; i < length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                res += (min - height[i]);
            }
        }
        return res;
    }

    public int trap1(int[] height) {
        int res = 0;

        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int left_max = 0;
            int right_max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left_max) {
                    left_max = height[j];
                }
            }

            for (int j = i + 1; j < length; j++) {
                if (height[j] > right_max) {
                    right_max = height[j];
                }
            }
            int min = Math.min(left_max, right_max);
            if (min > height[i]) {
                res += (min - height[i]);
            }
        }
        return res;
    }

//    public int trap(int[] height) {
//        int sum = 0;
//        int tmp_sum = 0;
//        boolean isStart = false;
//        int max = getMax(height);
//        for (int i = 1; i <= max; i++) {
//            for (int j = 0; j < height.length; j++) {
//                if (isStart && height[j] < i) {
//                    tmp_sum++;
//                }
//                if (height[j] >= i) {
//                    sum += tmp_sum;
//                    tmp_sum = 0;
//                    isStart = true;
//                }
//            }
//        }
//        return sum;
//    }
//
//    public int getMax(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > max) {
//                max = height[i];
//            }
//        }
//        return max;
//    }
}

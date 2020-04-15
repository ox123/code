package org.leetcode.str;

public class LargestRectangleArea_84 {
    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int []heights = {6, 4, 5, 2, 4, 3, 9};
        System.out.println(new LargestRectangleArea_84().largestRectangleArea(heights));
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
    /**
     * 在这种方法中，我们维护一个栈。一开始，我们把 -1 放进栈的顶部来表示开始。初始化时，按照从左到右的顺序，
     * 我们不断将柱子的序号放进栈中，直到遇到相邻柱子呈下降关系，也就是 a[i-1] > a[i]a[i−1]>a[i] 。
     * 现在，我们开始将栈中的序号弹出，直到遇到 stack[j]stack[j] 满足a\big[stack[j]\big] \leq a[i]a[stack[j]]≤a[i] 。
     * 每次我们弹出下标时，我们用弹出元素作为高形成的最大面积矩形的宽是当前元素与 stack[top-1]stack[top−1]
     * 之间的那些柱子。也就是当我们弹出 stack[top]stack[top] 时，记当前元素在原数组中的下标为 i ，
     * 当前弹出元素为高的最大矩形面积为：
     *
     * (i-stack[top-1]-1) \times a\big[stack[top]\big].
     * (i−stack[top−1]−1)×a[stack[top]].
     *
     */

}

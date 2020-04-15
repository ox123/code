package org.leetcode.str;

public class MaxContainer11 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxContainer11().maxArea(height));
    }

    /**
     * https://leetcode.com/problems/container-with-most-water/submissions/
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
//            res = height[i] < height[j] ?
//                    Math.max(res, (j - i) * height[i++]) :
//                    Math.max(res, (j - i) * height[j--]);
            res = Math.max((j - i) * Math.min(height[i], height[j]), res);
            if (height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }
}

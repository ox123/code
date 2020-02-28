package org.code.dynamic;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit_121 {
    public static void main(String[] args) {
//        int[] array = Utils.getUniqueArray(5);
        int [] array = {1,2};
        System.out.println(new MaxProfit_121().maxProfit(array));
    }


    /**
     * 暴力破解方法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            max = Math.max(max,prices[i]);
        }
        return max;
    }
    /**
     * 暴力破解方法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}

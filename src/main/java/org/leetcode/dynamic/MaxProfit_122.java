package org.leetcode.dynamic;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class MaxProfit_122 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new MaxProfit_122().maxProfit(arr));
    }

    /**
     * 只要有利润就累加，得到最后的结果
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                max += (prices[i + 1] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 使用波峰与波谷方法获取差值之和
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}

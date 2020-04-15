package org.leetcode.dynamic;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit_121 {
    public static void main(String[] args) {
//        int[] array = Utils.getUniqueArray(5);
        int[] array = {1, 2};
        System.out.println(new MaxProfit_121().maxProfit(array));
    }


    /**
     * 最大利润为最大值减去最小值，但是时间不能修改
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = min > prices[i] ? prices[i] : min;
//            if (min > prices[i]){
//                min = prices[i];
//            }
//            min = Math.min(min, prices[i]);
//            max = Math.max(max, prices[i] - min);
            max = max > prices[i] - min ? max : prices[i] - min;
        }
        return max;
    }

    /**
     * 暴力破解方法
     *
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

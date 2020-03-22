package org.code.dynamic;

public class CoinChange_322 {
    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        System.out.println(new CoinChange_322().coinChange(coins, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }

    public static int process(int arr[], int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        //index位置面值的决策，从0张开始
        for (int zhangshu = 0; arr[index] * zhangshu <= aim; zhangshu++) {
            res += process(arr, index + 1, aim - (arr[index] * zhangshu));
        }
        return res;
    }
}

package org.leetcode.dynamic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.programcreek.com/2015/04/leetcode-coin-change-java/
 *  * 解题思路： https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 */
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

    // 广度优先遍历的写法

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        visited[amount] = true;
        queue.offer(amount);

        // 排序是为了加快广度优先遍历过程中，对硬币面值的遍历，起到剪枝的效果
        Arrays.sort(coins);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer head = queue.poll();
                for (int coin : coins) {
                    int next = head - coin;
                    // 只要遇到 0，就找到了一个最短路径
                    if (next == 0) {
                        return step;
                    }

                    if (next < 0) {
                        // 由于 coins 升序排序，后面的面值会越来越大，剪枝
                        break;
                    }

                    if (!visited[next]) {
                        queue.offer(next);
                        // 添加到队列的时候，就应该立即设置为 true
                        // 否则还会发生重复访问
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        // 进入队列的顶点都出队，都没有看到 0 ，就表示凑不出硬币
        return -1;
    }
}

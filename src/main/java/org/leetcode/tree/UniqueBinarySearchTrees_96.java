package org.leetcode.tree;

/**
 * 解析： https://blog.csdn.net/mine_song/article/details/70552503
 */
public class UniqueBinarySearchTrees_96 {
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees_96().numTrees(5));
    }
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

package org.leetcode.dynamic;

/**
 * TODO
 * <p>
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MinFallingPathSum_931 {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new MinFallingPathSum_931().minFallingPathSum(A));
    }

    public int minFallingPathSum(int[][] A) {
        int result = Integer.MAX_VALUE;
        int row = A.length;
        for (int r = row - 2; r >= 0; --r) {
            for (int c = 0; c < row; ++c) {
                int best = A[r + 1][c];
                if (c > 0) {
                    best = Math.min(best, A[r + 1][c - 1]);
                }
                if (c + 1 < row) {
                    best = Math.min(best, A[r + 1][c + 1]);
                }
                A[r][c] += best;
            }
        }
        for (int x :
                A[0]) {
            result = Math.min(result, x);
        }
        return result;
    }
}

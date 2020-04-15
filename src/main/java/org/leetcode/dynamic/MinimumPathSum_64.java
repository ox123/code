package org.leetcode.dynamic;

public class MinimumPathSum_64 {
    public static void main(String[] args) {
        int[][] grid =
//                {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
                {{1, 2}, {1, 1}};
        System.out.println(new MinimumPathSum_64().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < col; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int r = 1; r < row; r++) {
            for (int j = 1; j < col; j++) {
                grid[r][j] = Math.min(grid[r - 1][j], grid[r][j-1]) + grid[r][j];
            }
        }
        return grid[row - 1][col - 1];
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //由于第一行和第一列不能用我们的递推式，所以单独更新
        //更新第一行的权值
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        //更新第一列的权值
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        //利用递推式更新其它的
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];

            }
        }
        return grid[m - 1][n - 1];
    }
}

package org.code.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 * @param triangle
 * @return
 */
public class Triangle_120 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        List<Integer> a1 = Arrays.asList(2);
        List<Integer> a2 = Arrays.asList(3, 4);
        List<Integer> a3 = Arrays.asList(6, 5, 7);
        List<Integer> a4 = Arrays.asList(4, 1, 8, 3);
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);
        System.out.println(arr);
        System.out.println(new Triangle_120().minimumTotal(arr));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int dp[][] = new int[row][row];
        List<Integer> lastRow = triangle.get(row - 1);
        for (int i = 0; i < row; i++) {
            dp[row - 1][i] = lastRow.get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            List<Integer> item = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + item.get(j);
            }
        }
        return dp[0][0];
    }
}

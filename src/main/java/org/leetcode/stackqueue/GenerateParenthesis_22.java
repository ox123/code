package org.leetcode.stackqueue;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(new GenerateParenthesis_22().generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs("", n, n, res);

        return res;
    }

    private void dfs(String s, int left, int right, List<String> res) {
        if (left <= 0 && right <= 0) {
            res.add(s);
            return;
        }
        if (left>right){
            return;
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(s + ")", left, right - 1, res);
        }
    }
}

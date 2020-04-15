package org.leetcode.stackqueue;

import java.util.LinkedList;
import java.util.Stack;

public class MinimumParentheseValid_921 {
    public static void main(String[] args) {
        String S = "()))((";
        System.out.println(new MinimumParentheseValid_921().minAddToMakeValid(S));
        LinkedList lst = new LinkedList();
        lst.offer("aaa");
    }

    public int minAddToMakeValid(String S) {
        if (S == null || S.length() <= 0) return 0;
        Stack<String> stack = new Stack<String>();
        char arr[] = S.toCharArray();
        for (char s :
                arr) {
            if (s == '(') {
                stack.push("c");
            } else if (s == ')') {
                if (!stack.isEmpty() && stack.peek() != ")") {
                    stack.pop();
                } else {
                    stack.push(")");
                }
            }
        }
        return stack.size();
    }

    /**
     * 最优解，不使用栈
     *
     * @param S
     * @return
     */
    public int minAddToMakeValid1(String S) {
        int left = 0, result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                left++;
            else if (left == 0)
                result++;
            else
                left--;
        }
        return result + left;
    }
}

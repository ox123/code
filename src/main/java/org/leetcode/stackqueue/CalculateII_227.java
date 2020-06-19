package org.leetcode.stackqueue;

import java.util.Stack;

public class CalculateII_227 {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(new CalculateII_227().calculate(s));
    }

    public int calculate(String s) {
        int res = 0;
        int length;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        if (s == null || (length = s.length()) == 0) return 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == length - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = ch;
                num = 0;
            }

        }
        for (int i :
                stack) {
            res += i;
        }
        return res;
    }
}

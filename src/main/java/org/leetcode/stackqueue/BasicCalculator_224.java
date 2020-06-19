package org.leetcode.stackqueue;

import java.util.Stack;

/**
 * TODO 待实现
 */
public class BasicCalculator_224 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = "2147483647";
        System.out.println(new BasicCalculator_224().calculate(s));
    }

    public int calculate(String s) {
        int result = 0;
        int length = s.length();
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += num * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}

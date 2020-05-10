package org.leetcode.stackqueue;

import java.util.Stack;

public class BasicCalculator_224 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator_224().calculate(s));
    }

    public int calculate(String s) {
        int result = 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        boolean flag = false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(') {
                if (!flag){

                }
            }
            if (chars[i] == ')') {

            }
        }
        return result;
    }
}

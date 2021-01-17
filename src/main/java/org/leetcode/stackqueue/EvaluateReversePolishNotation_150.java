package org.leetcode.stackqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
//        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(new EvaluateReversePolishNotation_150().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int first,second;
        for (String s :
                tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first - second);
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}

package org.code.str;

import java.util.Stack;

/**
 * TODO https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class ReverseParentheses_1190 {
    public static void main(String[] args) {
        String str = "(ed(et(oc))el)";
        StringBuilder builder = new StringBuilder(str);
        System.out.println(builder.reverse());
        System.out.println(new ReverseParentheses_1190().reverseParentheses(str));
        Stack<String> stack = new Stack<String>();
        stack.push("this is a");
        stack.push("hello");
        stack.push("");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }

    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<String>();
        stack.push("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c'){
                stack.push("");
            }else if (c == ')'){
                String pop = stack.pop();
                StringBuilder builder = new StringBuilder(stack.pop());
                for (int j = pop.length()-1;j>=0; j--) {
                    char cc = pop.charAt(j);
                    builder.append(cc);
                }
                stack.push(builder.toString());
            }else {
                String pop = stack.pop();
                pop += c;
                stack.push(pop);
            }
        }

        return stack.pop();
    }
}

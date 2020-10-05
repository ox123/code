package org.leetcode.stackqueue;

import java.util.Stack;

public class ValidateStackSequences_946 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(new ValidateStackSequences_946().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if (pushed.length != popped.length) return false;
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int s = -1;
        if (pushed.length != popped.length) return false;
        int[] st = new int[pushed.length];
        for (int i = 0, j = 0; i < pushed.length; i++) {
            st[++s] = pushed[i];
            while (s > 0 && st[s] == popped[j]) {
                s--;
                j++;
            }
        }
        return s < 0;
    }
}

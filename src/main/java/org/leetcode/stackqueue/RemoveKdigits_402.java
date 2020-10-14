package org.leetcode.stackqueue;

import java.util.ArrayDeque;

/**
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number
 * so that the new number is the smallest possible.
 */
public class RemoveKdigits_402 {
    public static void main(String[] args) {
        String num = "1234567890";
        int n = 2;
        System.out.println(new RemoveKdigits_402().removeKdigits(num, n));
    }

    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> dp = new ArrayDeque<Character>();
        for (char c :
                num.toCharArray()) {
            while (!dp.isEmpty() && c < dp.getLast() & k != 0) {
                dp.removeLast();
                k--;
            }
            dp.addLast(c);
        }
        while (k != 0) {
            dp.removeLast();
            k--;
        }
        while (!dp.isEmpty() && dp.getFirst() == '0') {
            dp.removeFirst();
        }
        StringBuilder builder = new StringBuilder();
        while (!dp.isEmpty()) {
            builder.append(dp.pollFirst());
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}

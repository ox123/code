package org.leetcode.bit;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits_191 {
    public static void main(String[] args) {
        int aa = 00000000000000000000000000001011;
        System.out.println(new NumberOf1Bits_191().hammingWeight(aa));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

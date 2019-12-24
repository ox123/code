package org.code.dynamic;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class NthUglyNumber_264 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(new NthUglyNumber_264().nthUglyNumber(n));
    }

    public int nthUglyNumber(int n) {
        int result = 0;
        int[] res = new int[n * 3];
        int[] factor = new int[]{2, 3, 5};
        for (int i = 0; i < n; i = i + 3) {
            for (int j = 0; j < 3; j++) {
                res[i + j] = factor[j] * (i + 1);
            }
            i += 2;
        }
        return res[n];
    }
}

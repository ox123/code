package org.code.dynamic;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * https://www.geeksforgeeks.org/ugly-numbers/
 */
public class NthUglyNumber_264 {
    public static void main(String[] args) {
        int a=0xFFFF;
        System.out.println(a);
        int n = 10;
        System.out.println(new NthUglyNumber_264().nthUglyNumber(n));
    }

    /**
     * TODO 结果太差，需要优化 https://leetcode.com/problems/ugly-number-ii/discuss/327344/O(N)-JAVA-SOLUTION-ITERATIVE
     *Runtime: 29 ms, faster than 31.61% of Java online submissions for Ugly Number II.
     * Memory Usage: 35.8 MB, less than 22.73% of Java online submissions for Ugly Number II.
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int uglyNo = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            uglyNo = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = uglyNo;
            if (uglyNo == factor2) {
                i2++;
                factor2 = 2 * ugly[i2];
            }
            if (uglyNo == factor3) {
                i3++;
                factor3 = 3 * ugly[i3];
            }
            if (uglyNo == factor5) {
                i5++;
                factor5 = 5 * ugly[i5];
            }
        }
        System.out.println(Arrays.toString(ugly));
        return uglyNo;
    }
}

package org.leetcode.recursion;

/**
 * 1. 分治
 * 2. 牛顿迭代法
 */
public class MyPow_50 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(new MyPow_50().myPow(x, n));
//        Math.pow()
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n < 0) {
            return (1 / x) * half * half;
        } else {
            return x * half * half;
        }
    }

}

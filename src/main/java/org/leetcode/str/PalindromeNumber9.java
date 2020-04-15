package org.leetcode.str;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(121));
    }

    /**
     * https://leetcode.com/problems/palindrome-number/submissions/
     * 左右两边同时开始比较，如果左右两边数值不等，则直接返回false，否则获取去掉两边的数字后继续；
     * 对于是负数或者能够被10整除的数，一定是返回false
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}

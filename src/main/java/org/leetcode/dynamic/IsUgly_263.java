package org.leetcode.dynamic;

public class IsUgly_263 {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(new IsUgly_263().isUgly(num));
    }

    /**
     * TODO Time Limit Exceeded
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
     * Memory Usage: 33.7 MB, less than 6.25% of Java online submissions for Ugly Number.
     *
     * @param num
     * @return
     */
    public boolean isUgly1(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            } else if (num % 3 == 0) {
                num /= 3;
                continue;
            } else if (num % 5 == 0) {
                num /= 5;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

package org.leetcode.str;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int num = 19;
        System.out.println(new HappyNumber().isHappy(num));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1) {
            n = squre(n);

            if (hashSet.contains(n)) return false;
            hashSet.add(n);
        }
        return true;
    }

    public int squre(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}

package org.code.bit;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/submissions/
 */
public class CountingBits_338 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(new CountingBits_338().countBits(n)));
    }

    public int[] countBits(int num) {
        int arr[] = new int[num + 1];
        arr[0] = 0;
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }
}

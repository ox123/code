package org.code.str;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class CarPooling_1094 {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        System.out.println(new CarPooling_1094().carPooling(trips,4));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        boolean res = true;
        int num = 1001;
        int n = trips.length;
        int[] a = new int[num];
        Arrays.fill(a,0);
//        for (int i = 0; i < num; i++) {
//            a[i] = 0;
//        }
        for (int i = 0; i < n; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                a[j] += trips[i][0];
            }
        }
        for (int i = 0; i < num; i++) {
            if (a[i] > capacity) {
                res = false;
                break;
            }
        }
        return res;
    }
}

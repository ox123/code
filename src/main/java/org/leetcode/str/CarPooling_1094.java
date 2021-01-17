package org.leetcode.str;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class CarPooling_1094 {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        System.out.println(new CarPooling_1094().carPooling(trips, 4));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int num = 0;
        int n = trips.length;
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][2] > num) num = trips[i][2];
        }
        int[] a = new int[num];
        for (int i = 0; i < n; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                a[j] += trips[i][0];
            }
        }
        for (int i = 0; i < num; i++) {
            if (a[i] > capacity) return false;
        }
        return true;
    }
}

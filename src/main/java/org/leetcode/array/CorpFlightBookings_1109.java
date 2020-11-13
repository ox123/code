package org.leetcode.array;

import java.util.Arrays;

public class CorpFlightBookings_1109 {
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ints = new CorpFlightBookings_1109().corpFlightBookings(bookings, 5);
        System.out.println(Arrays.toString(ints));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] book : bookings) {
            int start = book[0];
            int end = book[1];
            int seats = book[2];

            res[start - 1] += seats;
            if (end < n) {
                res[end] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    /**
     * 数组处理，复杂度o(n^2)
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] book : bookings) {
            int start = book[0];
            int end = book[1];
            int seats = book[2];
            for (int i = start; i <= end; i++) {
                res[i - 1] += seats;
            }
        }
        return res;
    }
}

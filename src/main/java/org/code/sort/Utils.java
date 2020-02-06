package org.code.sort;

import java.util.Random;

public class Utils {
    public static int[] getArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(i+1);
        }
        return a;
    }
}

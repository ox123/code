package org.code.sort;

import java.util.Random;

public class Utils {
    public static int[] getArray(int n) {
        int a[] = new int[n];
//        System.out.println(new Random().nextInt(n));
        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(n);
        }
        return a;
    }
}

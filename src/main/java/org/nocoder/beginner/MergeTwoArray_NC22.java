package org.nocoder.beginner;

import java.util.Arrays;

public class MergeTwoArray_NC22 {
    public void merge(int A[], int m, int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[m+i] = B[i];
        }
        Arrays.sort(A);
    }
}

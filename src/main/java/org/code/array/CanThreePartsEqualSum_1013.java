package org.code.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class CanThreePartsEqualSum_1013 {
    public static void main(String[] args) {
        int[] A = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(new CanThreePartsEqualSum_1013().canThreePartsEqualSum(A));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();

        return false;
    }
}

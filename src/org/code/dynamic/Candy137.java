package org.code.dynamic;

public class Candy137 {
    public static void main(String[] args) {
        int a[] = new int[]{1, 0, 2};
        System.out.println(new Candy137().candy(a));
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 0) return 0;
        int result = 0;
        int length = ratings.length;
        int num[] = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            int cur = 0;
            if (ratings[i] > ratings[i + 1]) {
                cur = num[i + 1] + 1;
            }
            num[i] = Math.max(num[i], cur);
        }
        for (int i = 0; i < length; i++) {
            result += num[i];
        }
        return result;
    }
}

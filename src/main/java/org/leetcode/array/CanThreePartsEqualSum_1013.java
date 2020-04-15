package org.leetcode.array;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class CanThreePartsEqualSum_1013 {
    public static void main(String[] args) {
        int[] A = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(new CanThreePartsEqualSum_1013().canThreePartsEqualSum(A));
    }

    public boolean canThreePartsEqualSum(int[] A) {
//        int sum = Arrays.stream(A).sum(); 性能太差
        int sum = 0;
        for (int num: A) {
            sum += num;
        }
        if (sum % 3 != 0) return false;
        int s = 0, c = 0;
        for (int a :
                A) {
            s += a;
            if (s == sum / 3) {
                c++;
                s = 0;
            }
        }
        return c >= 3;
    }

    public boolean canThreePartsEqualSum1(int[] A) {
        int sum = 0;
        for (int num: A) {
            sum += num;
        }
        // 数组A的和如果不能被3整除返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段,
        // 找到2段后就返回true（i只能到数组A的倒数第二个元素，保证了有第3段）
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curSum += A[i];
            if (curSum == sum) {
                cnt++;
                if (cnt == 2) {
                    return true;
                }
                curSum = 0;
            }
        }
        return false;
    }
}

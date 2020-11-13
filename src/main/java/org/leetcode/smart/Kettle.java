package org.leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.toutiao.com/i6804430536342241803/
 */
public class Kettle {
    private static class Status {
        int[] kettles = new int[3];

        Status(int k0, int k1, int k2) {
            kettles[0] = k0;
            kettles[1] = k1;
            kettles[2] = k2;
        }

        Status(Status status) {
            kettles[0] = status.kettles[0];
            kettles[1] = status.kettles[1];
            kettles[2] = status.kettles[2];
        }

        public boolean isSuccess(int code) {
            return kettles[0] == code || kettles[1] == code || kettles[2] == code;
        }

        @Override
        public boolean equals(Object obj) {
            Status status = (Status) obj;
            return kettles[0] == status.kettles[0] && kettles[1] == status.kettles[1] && kettles[2] == status.kettles[2];
        }
    }

    static int successCode = 4;                                     // 最终需要包含的状态
    static int[] capitals = {8, 5, 3};                              // 水壶容量
    static Status initStatus = new Status(8, 0, 0);                 // 初始值
    static List<Status> statuses = new ArrayList<Status>() {{       // 初始数组
        add(new Status(initStatus));
    }};
    static List<List<Status>> results = new ArrayList<>();          // 结果数组

    static void iterate(Status status, List<Status> statuses) {
        if (status.isSuccess(successCode)) {
            results.add(new ArrayList<>(statuses));
            return;
        }
        for (int i = 0; i < capitals.length; i++) {
            for (int j = 0; j < capitals.length; j++) {
                if (i == j) continue;
                if (status.kettles[i] == 0 || status.kettles[j] == capitals[j]) continue;
                int difference = Math.min(status.kettles[i], capitals[j] - status.kettles[j]);
                status.kettles[i] -= difference;
                status.kettles[j] += difference;
                if (!statuses.contains(status)) {
                    statuses.add(new Status(status));
                    iterate(status, statuses);
                    statuses.remove(status);
                }
                status.kettles[i] += difference;
                status.kettles[j] -= difference;
            }
        }
    }

    public static void main(String[] args) {
        iterate(initStatus, statuses);
        System.out.println("结果数量：" + results.size());
        results.forEach(statuses -> {
            statuses.forEach(status -> System.out.print(" -> " + status.kettles[0] + ", " + status.kettles[1] + ", " + status.kettles[2]));
            System.out.println();
        });
    }
}

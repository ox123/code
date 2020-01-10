package org.code.graph;

import java.util.*;

/**
 * TODO 难度较大，合理运用各种数据结构
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops_787 {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "123");
//        map.put("2", "234");
//        map.put("3", "345");
//        map.forEach((key, val) -> {
//            System.out.println(key + "---" + val);
//        });
//        PriorityQueue<String> queue = new PriorityQueue();
//        queue.offer("cc");
//        queue.offer("aa");
//        queue.offer("ff");
//        queue.offer("ee");
//        queue.forEach(f->{
//            System.out.println(f);
//        });
        int n = 3;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int K = 1;
        System.out.println(new CheapestFlightsWithinKStops_787().findCheapestPrice(n, flights, src, dst, K));
    }

    /**
     * https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/443735/Java-Dijkstra-algorithm-with-pruning-graph-based-on-number-of-stops
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     * @ Runtime: 8 ms, faster than 80.44% of Java online submissions for Cheapest Flights Within K Stops.
     * Memory Usage: 38.7 MB, less than 75.93% of Java online submissions for Cheapest Flights Within K Stops.
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (final int[] flight :
                flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(flight);
        }
        if (!graph.containsKey(src)) {
            return -1;
        }
        // TODO 理解使用场景，构造函数使用方式
        final PriorityQueue<int[]> minHeap = new PriorityQueue<>((f1, f2) -> f1[2] - f2[2]);
        minHeap.offer(new int[]{src, -1, 0});
        while (!minHeap.isEmpty()) {
            final int[] flight = minHeap.poll();
            int city = flight[0];
            int numStop = flight[1];
            int cost = flight[2];
            if (city == dst) {
                return cost;
            }
            if (numStop >= K) {
                continue;
            }
            if (graph.containsKey(city)) {
                graph.get(city).forEach(f -> {
                    minHeap.offer(new int[]{f[1], numStop + 1, cost + f[2]});
                });
            }
        }
        return -1;
    }
}

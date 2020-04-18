package org.ds.cache;

import java.util.*;

/**
 * 效率太低效
 *
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache_146 extends LinkedHashMap<Integer, Integer> {
    private Integer capacity;

    public LRUCache_146(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}

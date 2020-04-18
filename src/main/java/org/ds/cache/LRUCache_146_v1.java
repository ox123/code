package org.ds.cache;

import java.util.HashMap;

/**
 * 解法参考：https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache_146_v1 {

    class ListNode {
        Integer key, val;
        ListNode pre;
        ListNode next;

        ListNode(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    private ListNode dummyHead;
    private ListNode dummyTail;
    private HashMap<Integer, ListNode> map;


    private Integer capacity;

    public LRUCache_146_v1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new ListNode(-1, -1);
        dummyTail = new ListNode(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode listNode = map.get(key);
            int val = listNode.val;
            moveNode2Head(key);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode listNode = map.get(key);
            listNode.val = value;
            map.put(key, listNode);
        }
        if (map.size() == capacity){
            // 删除
            map.remove(key);
            removeTail();
        }
        ListNode newNode = new ListNode(key,value);
        map.put(key,newNode);
        addNode2Head(newNode);
    }

    private void removeTail() {
    }

    private void addNode2Head(ListNode newNode) {
    }

    private void moveNode2Head(int key) {

    }

}

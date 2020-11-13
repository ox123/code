package org.ds.cache;

import java.util.HashMap;

/**
 * 解法参考：https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/
 * <p>
 * https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * <p>
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

    public static void main(String[] args) {
        /**  测试用例通不过
         * ["LRUCache","get","put","get","put","put","get","get"]
         * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         */
        LRUCache_146_v1 cache = new LRUCache_146_v1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.map.keySet());

        int res1 = cache.get(1);
        System.out.println(res1);

        cache.put(3, 3);

        int res2 = cache.get(2);
        System.out.println(res2);

        int res3 = cache.get(3);
        System.out.println(res3);

        cache.put(4, 4);
        System.out.println(cache.map.keySet());

        int res4 = cache.get(1);
        System.out.println(res4);

        int res5 = cache.get(3);
        System.out.println(res5);

        int res6 = cache.get(4);
        System.out.println(res6);
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
            map.get(key).val = value;
            moveNode2Head(key);
            return;
        }
        if (map.size() == capacity) {
            // 删除
            ListNode listNode = removeTail();
            map.remove(listNode.key);

        }
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        addNode2Head(newNode);
    }

    private ListNode removeTail() {
        ListNode old = dummyTail.pre;
        ListNode newTail = old.pre;
        // 建立两侧节点
        newTail.next = dummyTail;
        dummyTail.pre = newTail;
        // 释放两侧节点
        old.next = null;
        old.pre = null;
        return old;
    }

    private void addNode2Head(ListNode newNode) {
        ListNode oldHeader = dummyHead.next;
        oldHeader.pre = newNode;
        newNode.pre = dummyHead;
        newNode.next = oldHeader;
        dummyHead.next = newNode;
    }

    private void moveNode2Head(int key) {
        ListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addNode2Head(node);
    }

}

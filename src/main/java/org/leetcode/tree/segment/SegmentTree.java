package org.leetcode.tree.segment;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;

    //构造函数 -- 通过用户传递的数组构建一颗吸纳段数
    public SegmentTree(E[] arr) {
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //创建一个空间为4n的静态数组
        tree = (E[]) new Object[arr.length * 4];
    }

    //获取线段树中实际元素的个数
    public int getSize() {
        return data.length;
    }

    //查找元素
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is Illegal");
        }
        return data[index];
    }
}

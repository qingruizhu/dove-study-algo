package com.dove.study.likou;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description: 706. 设计哈希映射
 * 难度
 * 简单
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * @Auther: qingruizhu
 * @Date: 2021/7/23 19:01
 */
public class Solution16 {
    private int cap = 769;
    private LinkedList<Pair>[] data;

    public Solution16() {
        data = new LinkedList[cap];
        for (int i = 0; i < cap; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<Pair> list = data[index];
        Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                return next.getValue();
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Pair> list = data[hash];
        Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                next.setValue(value);
                return;
            }
        }
        list.offerLast(new Pair(key, value));
    }

    public void remove(int key) {
        LinkedList<Pair> list = data[hash(key)];
        Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                iterator.remove();
                return;
            }
        }

    }

    private int hash(int key) {
        return key % cap;

    }

    public class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}

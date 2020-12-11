package com.dove.study.algo.queue_09;

/**
 * @Description: 数组实现队列  tail->1->2->3->4->5
 * @Auther: qingruizhu
 * @Date: 2020/10/19 16:58
 */
public class ArrayQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入
     */
    public boolean in(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出
     */
    public String out() {
        if (tail == head) {
            return null;
        }
        String rt = items[head];
        head++;
        return rt;
    }


}

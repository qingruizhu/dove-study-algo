package com.dove.study.algo.queue_09;

/**
 * @Description: 环形队列
 * @Auther: qingruizhu
 * @Date: 2020/10/22 09:20
 */
public class CircularQueue {

    private String[] items;
    private int n;
    private int head;
    private int tail;


    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入
     */
    public boolean in(String item) {
        //判断是否已满
        if ((tail + 1) % n == head) {
            return false;
        }
        //
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出
     */
    public String out() {
        //为空
        if (head == tail) {
            return null;
        }
        String rst = items[head];
        items[head] = null;
        head = (head + 1) % n;
        return rst;
    }


}

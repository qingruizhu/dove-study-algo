package com.dove.study.algo.queue_09;

/**
 * @Description: 数组实现动态队列  tail->1->2->3->4->5
 * @Auther: qingruizhu
 * @Date: 2020/10/19 16:58
 */
public class DynamicArrayQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入:支持动态添加
     */
    public boolean in(String item) {
        //尾巴已经达到数组容量，搬迁数据
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
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

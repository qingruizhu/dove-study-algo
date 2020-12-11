package com.dove.study.algo.queue_09;

/**
 * @Description: 链表实现队列
 * tail->1->2->3->4->5->head
 * @Auther: qingruizhu
 * @Date: 2020/10/20 09:53
 */
public class LinkedListQueue {

    private Node head = null;
    private Node tail = null;

    /**
     * 入：添加数据到队尾
     */
    public void in(String data) {
        Node node = new Node(data, null);
        // 队列为空
        if (head == null) {
            tail = head = node;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }

    /**
     * 出：从队首出
     */
    public String out() {
        if (null == head) {
            return null;
        }
        String data = head.getData();
        head = head.next;
        if (null == head) {
            tail = null;
        }
        return data;
    }


    public static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}


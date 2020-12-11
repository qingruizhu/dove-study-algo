package com.dove.study.algo.stack_08;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/9/29 10:42
 */
public class StackBaseOnLinkedList {

    private Node top = null;


    /**
     * pop
     */
    public int pop() {
        if (null == top) {
            return -1;
        }
        int rst = top.data;
        top = top.next;
        return rst;
    }

    /**
     * push
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        if (null != top) {
            newNode.next = top;
        }
        top = newNode;
    }


    public class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}

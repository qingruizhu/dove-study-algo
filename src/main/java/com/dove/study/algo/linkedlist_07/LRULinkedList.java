package com.dove.study.algo.linkedlist_07;

/**
 * @Description: 单链表实现LRU淘汰
 * 离head越远就是最近最少使用的数据
 * @Auther: qingruizhu
 * @Date: 2020/9/27 11:13
 */
public class LRULinkedList<T> {
    private static final Integer DEFAULT_CAPACITY = 10;

    private SNode<T> head = null;
    //链表长度
    private Integer length;
    //链表容量
    private Integer capacity;


    public LRULinkedList() {
        this.head = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }


    public LRULinkedList(int capacity) {
        this.head = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T t) {
        //1.检查该数据是否存在
        SNode pre = head;
        boolean have = false;
        while (pre != null && pre.next != null) {
            if (pre.next.element.equals(t)) {
                have = true;
                break;
            }
            pre = pre.next;
        }
        SNode<T> node = new SNode<>(t);
        //2.1 不存在，直接插入头节点
        if (!have) {
            if (length >= capacity) {
                //删除尾部节点
            }
            node.next = head.next;
            head.next = node;
            return;
        }
        //2.2 存在,移动到头节点
        pre.next = pre.next.next;
        node.next = head.next;
        head.next = node;
    }


    public static class SNode<T> {
        private T element;
        private SNode next;


        public SNode() {
        }

        public SNode(T e) {
            this.element = e;
        }

        public SNode(T e, SNode next) {
            this.element = e;
            this.next = next;
        }
    }
}


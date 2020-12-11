package com.dove.study.algo.linkedlist_06;

/**
 * @Description:实现单链表支持增删操作
 * @Auther: qingruizhu
 * @Date: 2020/9/22 16:26
 */
public class SingleLinkedList {

    private Node head = null;

    /**
     * 头部插入
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (null == head) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 尾部插入
     */
    public void insertToTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * 在当前node之后插入value
     */
    public void insertAfter(Node node, int value) {
        if (null == node) {
            return;
        }
        Node newNode = new Node(value, null);
        Node next = node.next;
        if (null == next) {
            node.next = newNode;
        } else {
            newNode.next = next;
            node.next = newNode;
        }
    }

    /**
     * 在当前node之前插入value
     */
    public void insertBefore(Node node, int value) {
        if (null == node) {
            return;
        }
        Node newNode = new Node(value, null);
        if (node == head) {
            insertToHead(newNode);
        } else {
            Node temp = head;
            while (temp != null && temp.next != node) {
                temp = temp.next;
            }
            newNode.next = node;
            temp.next = newNode;
        }
    }


    /**
     * deleteByNode
     */
    public void deleteByNode(Node node) {
        if (null == node || null == head) {
            return;
        }
        if (head == node) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != node) {
            temp = temp.next;
        }
        if (null == temp) {
            return;
        }
        temp.next = temp.next.next;
    }

    /**
     * deleteByValue
     */
    public void deleteByValue(int value) {
        if (null == head) {
            return;
        }
        Node temp = head;
        Node preTemp = null;
        while (null != temp && temp.data != value) {
            preTemp = temp;
            temp = temp.next;
        }
        if (null == temp) {
            return;
        }
        if (null == preTemp) {
            head = head.next;
        } else {
            preTemp.next = temp.next;
        }
    }

    public static class Node {
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

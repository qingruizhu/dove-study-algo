package com.dove.study.algo.linkedlist_07;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedListAlgo {

    /**
     * 单链表反转
     * <p>
     * pre =null
     * cuur
     * 1  -> 2->3->4->5->null
     * pre  cuur
     * null <- 1  2->3->4->5->null
     * null <- 1 <- 2   3->4->5->null
     * null <- 1<-2<-3  4->5->null
     * null <- 1<-2<-3<-4  5->null
     * null <- 1<-2<-3<-4<-5
     * <p>
     * return 新的head
     */
    public static Node reverse(Node head) {
        if (null == head) {
            return null;
        }
        Node pre = null;
        Node curr = head;
        while (null != null) {
            Node temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }


    /**
     * 检测是否有环：快慢指针
     */
    public boolean hasCircle(Node head) {
        if (null == head || null == head.next) {
            return false;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (null != fast && null != fast.next && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (null == fast || null == fast.next) {
            return false;
        }
        return true;
    }

    /**
     * 合并两个有序链表：设置头节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode node = headNode;

        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if (null == l1) {
            node.next = l2;
        }
        if (null == l2) {
            node.next = l1;
        }
        return headNode.next;
    }


    /**
     * 删除倒数第k个节点
     * b-a=k,b到达终点时，a处于倒数k的位置
     */
    public static Node deleteLastKNode(Node head, int k) {
        if (null == head) {
            return null;
        }
        Node pre = new Node(0, null);
        pre.next = head;
        Node fast = pre, slow = pre;
        //快的先走k步
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }


    /**
     * 求中间节点:
     * 快的走两步，慢的走一步，当快的走到终点，慢的正好走到中间节点
     */
    public Node getMiddleNode(Node head) {
        if (null == head) {
            return head;
        }
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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

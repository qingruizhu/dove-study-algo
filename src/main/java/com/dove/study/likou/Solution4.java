package com.dove.study.likou;

/**
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/1/29 下午2:41
 */
public class Solution4 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode head = l1;
        boolean go = false;
        int aa = l1.val + l2.val;
        if (aa > 9) {
            head.val = aa % 10;
            go = true;
        } else {
            head.val = aa;
        }


        while (l1.next != null || l2.next != null) {
            if (l1.next != null) {
                if (l2.next != null) {
                    int plus = l1.next.val + l2.next.val;
                    if (go) {
                        plus++;
                    }
                    if (plus > 9) {
                        l1.next.val = plus % 10;
                        go = true;
                    } else {
                        l1.next.val = plus;
                        go = false;
                    }
                    l2 = l2.next;
                } else {
                    int l1val = l1.next.val;
                    if (go) {
                        l1val++;
                    }
                    if (l1val > 9) {
                        l1.next.val = l1val % 10;
                        go = true;
                    } else {
                        l1.next.val = l1val;
                        go = false;
                    }
                }
                l1 = l1.next;
            } else {
                //
                int l2val = l2.next.val;
                if (go) {
                    l2val++;
                }
                if (l2val > 9) {
                    l2val = l2val % 10;
                    go = true;
                } else {
                    go = false;
                }
                l1 = l1.next = new ListNode(l2val, null);
                l2 = l2.next;
            }
        }
        if (go) {
            l1.next = new ListNode(1);
        }
        return head;
    }


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

}

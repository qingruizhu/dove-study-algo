package com.dove.study.algo.tree_24;

/**
 * @Description: 二叉查找树
 * @Auther: qingruizhu
 * @Date: 2021/1/22 上午9:53
 */
public class BinarySeachTree {

    private Node root;


    /**
     * 查找
     */
    public Node search(int value) {
        Node tmp = root;
        while (tmp != null) {
            if (value < root.data) {
                tmp = root.left;
            } else if (value > root.data) {
                tmp = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    /**
     * 插入
     */
    public void insert(int value) {
        if (null == root) {
            root = new Node(value);
            return;
        }
        Node tmp = root;
        while (null != tmp) {
            if (value < tmp.data) {
                if (null == tmp.left) {
                    tmp.left = new Node(value);
                    return;
                }
                tmp = tmp.left;
            } else {
                if (null == tmp.right) {
                    tmp.right = new Node(value);
                    return;
                }
                tmp = tmp.right;
            }
        }
    }

    /**
     * 删除
     */
    public void delete(int value) {
        // 1. 找到要删除的节点 和 他的父节点
        Node tmp = root;
        Node pTmp = null;
        while (null != tmp && value != tmp.data) {
            pTmp = tmp;
            if (value < tmp.data) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (null == tmp) { //没有该值
            return;
        }
        // 2. 要删除的 tmp 有两个子节点
        if (tmp.left != null && tmp.right != null) {
            // 在右子树中找出最小的节点 和 他的父节点
            Node min = tmp.right;
            Node pMin = tmp;
            while (min.left != null) {
                pMin = min;
                min = min.left;
            }
            // 替换最小节点数据
            tmp.data = min.data;
            // 替换要删除的节点
            tmp = min;
            pTmp = pMin;
        }
        // 3. 要删除的节点是叶子节点或者只有一个子节点
        Node cTmp; // 标记要删除的节点的子节点
        if (tmp.left != null) {
            cTmp = tmp.left;
        } else if (tmp.right != null) {
            cTmp = tmp.right;
        } else {
            cTmp = null;
        }
        // 把 cTmp 挂在 pTmp 下
        if (pTmp == null) {
            root = cTmp;
        } else if (pTmp.left == tmp) {
            pTmp.left = cTmp;
        } else {
            pTmp.right = cTmp;
        }
    }

    /**
     * 找出最小节点
     */
    public Node findMin() {
        if (null == root) {
            return null;
        }
        Node min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    /**
     * 找出最大节点
     */
    public Node finMax() {
        if (null == root) {
            return null;
        }
        Node max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }


    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

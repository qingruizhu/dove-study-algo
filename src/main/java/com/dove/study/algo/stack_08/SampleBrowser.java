package com.dove.study.algo.stack_08;

/**
 * @Description: 链表栈实现浏览器的前进后退功能
 * @Auther: qingruizhu
 * @Date: 2020/10/13 09:40
 */
public class SampleBrowser {

    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    // open：打开一个新页面，把当前页面放入 backStack，然后清空 forwardStack
    public void open(String url) {
        backStack.push(url);
        forwardStack.clear();
    }


    // 回退：取 backStack 的 top 放入 forwardStack
    public String goBack() {
        if (backStack.size > 0) {
            String pop = backStack.pop();
            forwardStack.push(pop);
            return pop;
        }
        return null;

    }

    // 前进 取 forwardStack 的 top 放入 backStack
    public String goForward() {
        if (forwardStack.size > 0) {
            String pop = forwardStack.pop();
            backStack.push(pop);
            return pop;
        }
        return null;
    }

    // 当前页面
    public String currentPage() {
        return backStack.getTop().data;
    }


    /**
     * 链表实现的栈
     */
    public class LinkedListBasedStack {

        private Node top;
        private int size;

        // pop
        public String pop() {
            if (null == top) {
                return null;
            }
            String data = this.top.data;
            this.top = this.top.next;
            this.size--;
            return data;
        }

        // push
        public void push(String data) {
            Node node = new Node(data, this.top);
            this.top = node;
            this.size++;
        }

        // clear
        public void clear() {
            this.top = null;
            this.size = 0;
        }

        // print 全部数据
        public void print() {
            System.out.println("Print stack:");
            Node tmp = this.top;
            while (null != tmp) {
                String data = tmp.data;
                System.out.println(data + "\t");
                tmp = tmp.next;
            }
            System.out.println();
        }

        public Node getTop() {
            return top;
        }

        public void setTop(Node top) {
            this.top = top;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }


    /**
     * 链表节点
     */
    public class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this(data, null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

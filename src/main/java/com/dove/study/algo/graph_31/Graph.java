package com.dove.study.algo.graph_31;

import java.util.LinkedList;

/**
 * @Description: 无向图 <- 邻接表
 * @Auther: qingruizhu
 * @Date: 2021/6/4 上午10:23
 */
public class Graph {

    private int v; // 顶点个数？顶点的最大数值
    private LinkedList<Integer> arr[];//邻接表

    /**
     * 初始化
     **/
    public Graph(int v) {
        this.v = v;
        arr = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    /**
     * 无向边存两次
     **/
    private void addEdge(int a, int b) {
        arr[a].add(b);
        arr[b].add(a);
    }


    /**
     * 广度搜索
     **/
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 顶点是否被访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 当前正在访问的顶点
        LinkedList<Integer> quque = new LinkedList<>();
        quque.add(s);
        // 走过的路线
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        // go
        Integer poll = null;
        while ((poll = quque.poll()) != null) {
            LinkedList<Integer> nodes = arr[poll];
            for (int i = 0; i < nodes.size(); i++) {
                int node = nodes.get(i);
                if (!visited[node]) { // 没被访问
                    pre[node] = poll;// 添加访问路径
                    if (node == t) {
                        // 输出访问路径
                        printWay(pre, s, t);
                        return;
                    }
                    visited[node] = true;
                    quque.add(node);
                }
            }
        }
    }

    private void printWay(int[] pre, int s, int t) {
        if (pre[t] != -1 && s != t) {
            printWay(pre, s, pre[t]);
        }
        System.out.println(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0, 6);

        // 深度优先
//        graph.dfs(0, 6);

    }


}

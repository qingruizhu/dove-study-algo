package com.dove.study.algo.heap_28;

/**
 * @Description: 大顶堆：子节点都小于父节点
 * @Auther: qingruizhu
 * @Date: 2021/1/27 下午4:07
 */
public class Heap {

    private int[] arr;// 数组实现
    private int n;// 堆的最大存储
    private int count;// 已经存储的数据个数

    public Heap(int capacity) {
        arr = new int[capacity + 1];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 插入:由下往上实现堆化
     */
    public void insert(int value) {
        if (count >= n) {
            return;
        }
        arr[++count] = value;
        int index = count;
        while (index / 2 > 0 && arr[index] > arr[index / 2]) {
            // 交换
            int tmp = arr[index];
            arr[index] = arr[index / 2];
            arr[index / 2] = tmp;
            index = index / 2;
        }
    }


    /**
     * 删除堆顶元素：由上往下实现堆化
     */
    public void removeTop() {
        if (count == 0) {
            return;
        }
        // 替换堆顶和堆底元素
        arr[1] = arr[count];
        arr[count] = 0;
        count--;
        // 堆化
        int index = 1;
        while (((index * 2) < count && arr[index * 2] > arr[index]) || ((index * 2 + 1) < count && arr[index * 2 + 1] > arr[index])) {
            if (arr[index * 2] > arr[index]) {
                if (arr[index * 2] > arr[index * 2 + 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index * 2];
                    arr[index * 2] = tmp;
                    index = index * 2;
                } else {
                    int tmp = arr[index];
                    arr[index] = arr[index * 2 + 1];
                    arr[index * 2 + 1] = tmp;
                    index = index * 2 + 1;
                }
                continue;
            }
            if (arr[index * 2 + 1] > arr[index]) {
                int tmp = arr[index];
                arr[index] = arr[index * 2 + 1];
                arr[index * 2 + 1] = tmp;
                index = index * 2 + 1;
            }
        }
    }

    public void removeTop2() {
        if (count == 0) return; // 堆中没有数据
        arr[1] = arr[count];
        --count;
        heapify(arr, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            int tmp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = tmp;
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(6);
        for (int i = 0; i < 9; i++) {
            heap.insert(i);
        }
        System.out.println(heap.toString());
//        heap.removeTop();
        heap.removeTop2();
        System.out.println(heap.toString());
    }
}

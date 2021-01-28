package com.dove.study.algo.heap_28;

/**
 * @Description: 堆排序：建堆+排序
 * @Auther: qingruizhu
 * @Date: 2021/1/28 上午9:19
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {8, 3, 16, 66, 20, 19, 5, 88, 99, 34, 26};
        sort(arr);
        System.out.println(arr);
    }


    /**
     * 排序
     * <p>
     * 堆元素是从数组下标0开始
     *
     * @param arr
     */
    public static void sort2(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 1、建堆
        buildHeap(arr);
        // 99 88 19 66 34 16 5 3 8 20 26
        // 2、排序
        int k = arr.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(arr, --k, 0);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify2(arr, arr.length - 1, i);
        }
    }

    /**
     * 堆化
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify2(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }


    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 1.建堆：从上往下
        // 1.1 找到最后一个非叶子节点，然后把所有的非叶子节点堆化
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            // 1.2 堆化
            heapify(arr, arr.length - 1, i);
        }
        // 2. 排序
        for (int i = arr.length - 1; i > 0; ) {
            // 堆顶和堆尾互换，然后堆化
            swap(arr, 0, i);
            // 从顶部开始堆化
            heapify(arr, --i, 0);
        }
    }


    private static void heapify(int[] arr, int n, int tmpI) {
        while (true) {
            int maxIndex = tmpI;
            if (((tmpI * 2 + 1) <= n) && arr[tmpI * 2 + 1] > arr[maxIndex]) {
                maxIndex = tmpI * 2 + 1;
            }
            if (((tmpI * 2 + 2) <= n) && arr[tmpI * 2 + 2] > arr[maxIndex]) {
                maxIndex = tmpI * 2 + 2;
            }
            if (maxIndex == tmpI) {
                break;
            }
            // 交换
            swap(arr, maxIndex, tmpI);
            //
            tmpI = maxIndex;
        }
    }


}

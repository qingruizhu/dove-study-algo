package com.dove.study.algo.sorts_12;

public class QuickSort {


    public static void main(String[] args) {
        int[] test = {10, 5, 6, 19, 30, 21, 9, 3, 1000, 44, 555, 2000, 3000};
        quickSot(test, 0, test.length - 1);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }


    public static void quickSot(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 1.首先定位分区点
        int q = partition(arr, p, r);
        // 2.递归快排 分区点前的数据
        quickSot(arr, p, q - 1);
        // 3.递归快排 分区点后的数据
        quickSot(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        // 以下操作保证 i左边的数据<pivot
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                // i==j 时没必要交换
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                i++;
            }
        }
        //
        int temp = arr[i];
//        System.out.println("分区点：" + temp);
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }
}

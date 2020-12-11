package com.dove.study.algo.sorts_11;

/**
 * @Description: 1.冒泡
 * 2.插入
 * 3.选择
 * @Auther: qingruizhu
 * @Date: 2020/10/23 09:58
 */
public class Sorts {

    public static void main(String[] args) {
        int[] test = {5, 9, 1, 4, 3, 2, 145, 76, 1, 234, 676, 2};
//        bubbleSort(test);
//        insertionSort(test);
        selectSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + "\t");
        }
    }


    /**
     * 冒泡：最大的往后冒
     */
    public static void bubbleSort(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //提前跳出标识
            boolean br = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换位置
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    br = false;
                }
            }
            if (br) {
                // 没有数据交换，提前退出
                break;
            }
        }
    }

    /**
     * 插入：比较+交换位置
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int ch = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //比较
                if (arr[j] > ch) {
                    //交换
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = ch;
        }
    }

    public static void selectSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            int tindex = i;
            for (int j = i + 1; j < n; j++) {
                //换位置
                if (arr[tindex] > arr[j]) {
                    tindex = j;
                }
            }
            if (tindex != i) {
                int tmp = arr[i];
                arr[i] = arr[tindex];
                arr[tindex] = tmp;
            }
        }
    }

}

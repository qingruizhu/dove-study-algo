package com.dove.study.algo.sorts_13;

/**
 * @Description: 基数排序：对每一位的数字进行计数排序
 * @Auther: qingruizhu
 * @Date: 2021/1/11 上午10:38
 */
public class RadixSort {


    public static void main(String[] args) {
        int[] test = {10, 5, 6, 19, 6, 9, 20, 30, 20,198,3349,89,4};
        // 找出最大值
        int max = test[0];
        for (int i = 1; i < test.length; i++) {
            if (test[i] > max) {
                max = test[i];
            }
        }
        // 循环排序每一位
        for (int i = 1; max / i > 0; i *= 10) {
            radixSort(test, i);
        }
        //
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static void radixSort(int[] arr, int bitPosition) {
        if (arr.length <= 1) {
            return;
        }
        // 首先模拟个位上的数字排序

        // 分数区间为：0-9
        int[] sortArr = new int[10];
        // 找出每个分数出现的次数
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] / bitPosition) % 10;
            sortArr[index]++;
        }
        // 分数出现的次数累加
        for (int i = 1; i < sortArr.length; i++) {
            sortArr[i] += sortArr[i - 1];
        }
        //申请临时数组进行排序
        int[] tempArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = (arr[i] / bitPosition) % 10;
            tempArr[sortArr[index] - 1] = arr[i];
            // sort-1
            sortArr[index]--;
        }
        // 转移数据
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i];
        }
    }
}

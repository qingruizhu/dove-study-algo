package com.dove.study.algo.sorts_12;

/**
 * @Description: 计数排序
 * @Auther: qingruizhu
 * @Date: 2021/1/8 上午10:22
 */

public class CountingSort {


    public static void main(String[] args) {
        int[] test = {10, 5, 6, 19, 6, 9, 20, 30, 20};
        countingSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static void countingSort(int[] arr) {
        int cap = arr.length;
        if (cap <= 1) {
            return;
        }
        // 1. 找到分数范围
        int max = arr[0];
        for (int i = 1; i < cap; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 申请分数数组
        int[] scoreArr = new int[max + 1];
        // 2. 找到分数出现的次数
        for (int i = 0; i < cap; i++) {
            int tpScore = arr[i];
            scoreArr[tpScore] = scoreArr[tpScore] + 1;
        }
        // 3. 分数出现的次数累加
        for (int i = 1; i < scoreArr.length; i++) {
            scoreArr[i] = scoreArr[i] + scoreArr[i - 1];
        }
        // 4.开始排序
        // 准备临时数组放入有序的值
        int[] tmpArr = new int[cap];
        for (int i = cap - 1; i >= 0; i--) {
            int arrTmp = arr[i];
            int count = scoreArr[arrTmp];
            tmpArr[count - 1] = arrTmp;
            scoreArr[arrTmp]--;
        }
        //
        for (int i = 0; i < tmpArr.length; i++) {
            arr[i] = tmpArr[i];
        }
    }


}

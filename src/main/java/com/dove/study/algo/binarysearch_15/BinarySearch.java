package com.dove.study.algo.binarysearch_15;

/**
 * @Description: 二分查找
 * @Auther: qingruizhu
 * @Date: 2021/1/11 上午11:23
 */
public class BinarySearch {

    public static void main(String[] args) {
//        int[] test = {5, 9, 18, 29, 59, 88};
//        int i = bSearch(test, 18);
//        System.out.println(i);
        double sqrt = sq(7);
        System.out.println(sqrt);
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param passive
     * @return
     */
    public static int bSearch(int[] arr, int passive) {
        // 1. 定义启止位置
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //计算中间位置
//            int middle = (end + start) / 2;
            int middle = start + ((end - start) >> 1);
            if (arr[middle] == passive) {
                return middle;
            } else if (arr[middle] < passive) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }


    /**
     * 求平方根
     *
     * @param x
     * @return
     */
    public static double sq(double x) {
        if (x < 0) {
            return Double.NaN;
        }
        double left = 0;
        double right = x;
        //小于1的时候
        if (x < 1 && x > 0) {
            left = x;
            right = 1;
        }
        double middle = left + (right - left) / 2;
        while (left + 0.01 < right) {
            if (middle * middle > x) {
                right = middle;
            } else if (middle * middle < x) {
                left = middle;
            } else {
                return middle;
            }
            middle = left + (right - left) / 2;
        }
        return middle;

    }
}

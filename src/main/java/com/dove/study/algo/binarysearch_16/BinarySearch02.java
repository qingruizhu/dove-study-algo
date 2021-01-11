package com.dove.study.algo.binarysearch_16;

/**
 * @Description: 二分查找变种
 * @Auther: qingruizhu
 * @Date: 2021/1/11 下午2:49
 */
public class BinarySearch02 {


    public static void main(String[] args) {
//        int[] test = {5, 6, 7, 8, 9, 9, 9, 18, 18, 29, 59, 88};
//        int i = bsearch01(test, 9);
//        int i = bsearch02(test, 9);
//        int i = bsearch03(test, 17);
        // ip 归属查找
        int[] ip = {100, 200, 201, 600, 601, 1000};
        int i = bsearch04(ip, 500);
        System.out.println(i);
    }

    /**
     * 查找出第一个值等于给定值的元素
     *
     * @param arr
     * @param passive
     * @return
     */
    public static int bsearch01(int[] arr, int passive) {
//        int[] test = {5, 6, 7, 8, 9, 9, 9, 18, 18, 29, 59, 88};
        int left = 0;
        int right = arr.length - 1;

        int middle = left + (right - left) / 2;

        while (left <= right) {
            if (arr[middle] > passive) {
                right = middle - 1;
            } else if (arr[middle] < passive) {
                left = middle + 1;
            } else {
                if (middle == 0 || arr[middle - 1] != passive) {
                    return middle;
                }
                right = middle - 1;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }


    /**
     * 查找出最后一个值等于给定值的元素
     *
     * @param arr
     * @param passive
     * @return
     */
    public static int bsearch02(int[] arr, int passive) {
//        int[] test = {5, 6, 7, 8, 9, 9, 9, 18, 18, 29, 59, 88};
        int left = 0;
        int right = arr.length - 1;

        int middle = left + (right - left) / 2;

        while (left <= right) {
            if (arr[middle] > passive) {
                right = middle - 1;
            } else if (arr[middle] < passive) {
                left = middle + 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] != passive) {
                    return middle;
                }
                left = middle + 1;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }


    /**
     * 查找出第一个大于等于给定值的元素
     *
     * @param arr
     * @param passive
     * @return
     */
    public static int bsearch03(int[] arr, int passive) {
//        int[] test = {5, 6, 7, 8, 9, 9, 9, 18, 18, 29, 59, 88};
        int left = 0;
        int right = arr.length - 1;

        int middle = left + (right - left) / 2;

        while (left <= right) {
            if (arr[middle] >= passive) {
                if (middle == 0 || arr[middle - 1] < passive) {
                    return middle;
                }
                right = middle - 1;
            } else if (arr[middle] < passive) {
                left = middle + 1;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }


    /**
     * 查找出最后一个小于等于给定值的元素
     *
     * @param arr
     * @param passive
     * @return
     */
    public static int bsearch04(int[] arr, int passive) {
//        int[] test = {5, 6, 7, 8, 9, 9, 9, 18, 18, 29, 59, 88};
        int left = 0;
        int right = arr.length - 1;

        int middle = left + (right - left) / 2;

        while (left <= right) {
            if (arr[middle] > passive) {
                right = middle - 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] > passive) {
                    return middle;
                }
                left = middle + 1;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }

}

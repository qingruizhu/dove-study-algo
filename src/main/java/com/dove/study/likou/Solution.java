package com.dove.study.likou;

/**
 * @Description: 两数之和=target
 * @Auther: qingruizhu
 * @Date: 2021/1/27 下午6:08
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int[] ints = twoSum(arr, 6);
        System.out.println(ints);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};

                }

            }

        }
        return null;
    }
}

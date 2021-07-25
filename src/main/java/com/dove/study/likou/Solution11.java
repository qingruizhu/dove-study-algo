package com.dove.study.likou;

/**
 * <<<<<<< Updated upstream
 *
 * @Description: 665. 非递减数列
 * 难度
 * 简单
 * <p>
 * 473
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * @Auther: qingruizhu
 * @Date: 2021/2/7 下午2:57
 */
public class Solution11 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 2};
        boolean b = checkPossibility(arr);
        System.out.println(b);

    }


    public static boolean checkPossibility(int[] nums) {
        if (null == nums) {
            return false;
        }
        if (nums.length <= 2) {
            return true;
        }
        int count = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] > nums[i]) {
                if (--count < 0) {
                    return false;
                }
//                if (i + 1 < nums.length) {
                if (nums[i + 1] < nums[i]) {
                    if (--count < 0) {
                        return false;
                    }
                    nums[i + 1] = nums[i];
                }
//                }
            } else {
//                if (i + 1 < nums.length) {
                if (nums[i + 1] < nums[i]) {
                    if (nums[i - 1] > nums[i + 1]) {
                        if (--count < 0) {
                            return false;
                        }
                        nums[i + 1] = nums[i];
                    } else {
                        if (--count < 0) {
                            return false;
                        }
                        nums[i] = nums[i + 1];
                    }
                }
//                }
            }
        }
        return true;
    }
}
package com.dove.study.likou;

/**
 * @Description: 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心索引可能出现在数组的两端。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/1/28 下午5:44
 */
class Solution2 {

    public static void main(String[] args) {
        int[] test = {2, 1, -1};
        int i = pivotIndex(test);
        System.out.println(i);
    }

    public static int pivotIndex(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum - nums[0] == 0) {
            return 0;
        }
        int left = 0, right = 0;
        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            right = sum - left - nums[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
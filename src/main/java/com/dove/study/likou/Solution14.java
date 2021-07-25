package com.dove.study.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:15. 三数之和
 * 难度
 * 中等
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * @Auther: qingruizhu
 * @Date: 2021/7/22 17:55
 */
public class Solution14 {

    /**
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return rst;
        }
        Arrays.sort(nums);
        // 双指针
        for (int i = 0; i < nums.length - 2; i++) {
            int crt = nums[i];
            if (crt > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, rignt = nums.length - 1;
            while (left < rignt) {
                int sum = crt + nums[left] + nums[rignt];
                if (sum == 0) {
                    rst.add(Arrays.asList(crt, nums[left], nums[rignt]));
                    left++;
                    rignt--;
                    while (left<rignt && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left<rignt && nums[rignt] == nums[rignt+1]) {
                        rignt--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    rignt--;
                }
            }
        }
        return rst;
    }

}

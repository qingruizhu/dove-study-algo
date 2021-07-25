package com.dove.study.likou;

/**
 * 75. 颜色分类
 * 难度
 * 中等
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        // 双指针，0往前挪，2往后挪
        int left = 0, ritght = nums.length - 1;
        for (int i = 0; i <= ritght; i++) {

            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            } else if (nums[i] == 2) {
                nums[i] = nums[ritght];
                nums[ritght] = 2;
                ritght--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }
}

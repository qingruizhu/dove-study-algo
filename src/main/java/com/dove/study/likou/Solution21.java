package com.dove.study.likou;

import java.util.Stack;

/**
 * @Description: 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * @Auther: qingruizhu
 * @Date: 2021/7/27 上午9:27
 */
public class Solution21 {


    public boolean canPartition(int[] nums) {


        return false;

    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        if (null == s || s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            char peek = stack.peek();
            if ((c == ')' && peek == '(') ||
                    (c == '}' && peek == '{') ||
                    (c == ']' && peek == '[')) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.empty();
    }


}

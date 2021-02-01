package com.dove.study.likou;

import java.util.Arrays;

/**
 * @Description: * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * *
 * * 示例:
 * * 给定有序数组: [-10,-3,0,5,9],
 * *
 * * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * *
 * *           0
 * *          / \
 * *        -3   9
 * *        /   /
 * *      -10  5
 * *
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * * @Auther: qingruizhu
 * * @Date: 2021/2/1 23:10
 */
public class Solution10 {

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
//        TreeNode treeNode = sortedArrayToBST2(arr);
        TreeNode treeNode = sortedArrayToBST(arr);
        System.out.println(treeNode);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);

    }

    public static TreeNode help(int[] nums, int low, int hight) {
        if (low > hight) {   // low > high表示子数组为空
            return null;
        }
        int mid = (hight - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, low, mid - 1);
        root.right = help(nums, mid + 1, hight);
        return root;
    }


    public static TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) return null;
        // 中位数 作为根节点
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        // 左侧数组的中位数作为左子节点
        root.left = sortedArrayToBST2(Arrays.copyOfRange(nums, 0, nums.length / 2));

        // 右侧数组的中位数作为右子节点
        root.right = sortedArrayToBST2(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

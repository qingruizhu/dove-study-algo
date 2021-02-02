package com.dove.study.likou;

import java.util.LinkedList;

/**
 * @Description: 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * <p>
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * <p>
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * <p>
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/2/1 下午5:00
 */
public class Solution8 {

    public static void main(String[] args) {
        int[][] adjacentPairs = {{4, 2}, {1, 4}, {-3, 1}};
        int[] ints = restoreArray(adjacentPairs);
        System.out.println(ints);

        //  [-2,4,1,-3]
    }


    public static int[] restoreArray(int[][] adjacentPairs) {
        LinkedList<Integer> rst = new LinkedList<>();
//        rst.addLast(adjacentPairs[0][0]);
//        rst.addLast(adjacentPairs[0][1]);
//        adjacentPairs[0] = null;
        int i = 0;
        int nullNum = 0;
        while (true) {
            if (adjacentPairs[i] != null) {
                int left = adjacentPairs[i][0];
                int right = adjacentPairs[i][1];
                if (left > right) {
                    int tmp = left;
                    left = right;
                    right = tmp;
                }
                if (rst.contains(left)) {
                    rst.addLast(right);
                    adjacentPairs[i] = null;
                    nullNum++;
                } else if (rst.contains(right)) {
                    rst.addFirst(left);
                    adjacentPairs[i] = null;
                    nullNum++;
                } else {
                    if (rst.size() <= 0) {
                        rst.addLast(left);
                        rst.addLast(right);
                        adjacentPairs[i] = null;
                        nullNum++;
                    }

                }
            } else {
                nullNum++;
            }
            if (i == adjacentPairs.length - 1) {
                if (nullNum != adjacentPairs.length) {
                    nullNum = 0;
                } else {
                    System.out.println("hhh");
                    break;
                }
                i = 0;
            } else {
                i++;
            }
        }
        int[] arr = new int[rst.size()];
        for (int j = 0; j < rst.size(); j++) {
            arr[j] = rst.get(j);
        }
        return arr;
    }


}

package com.dove.study.likou;

import java.util.Arrays;

/**
 * @Description: 240. 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * @Auther: qingruizhu
 * @Date: 2021/7/24 23:05
 */
public class Solution20 {


    public boolean searchMatrix(int[][] matrix, int target) {
        // 从 m*n 左下角开始走
        int down = matrix.length - 1, left = 0;

        while (down >= 0 && left <= matrix[0].length - 1) {
            if (matrix[down][left] > target) {
                --down;
            } else if (matrix[down][left] < target) {
                ++left;
            } else {
                return true;
            }
            Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        }
        return false;

    }
}

package com.dove.study.likou;

/**
 * @Description: 59. 螺旋矩阵 II
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * @Auther: qingruizhu
 * @Date: 2021/7/24 23:05
 */
public class Solution19 {


    public int[][] generateMatrix(int n) {

        int[][] rst = new int[n][n];


        int left = 0, rignt = n - 1, top = 0, down = n - 1, index = 0;

        while ((index+1) <= n * n) {
            for (int i = left; i <= rignt; i++) {
                rst[top][i] = ++index;
            }
            top++;
            for (int i = top; i <= down; i++) {
                rst[i][rignt] = ++index;
            }
            rignt--;
            for (int i = rignt; i >= left; i--) {
                rst[down][i] = ++index;
            }
            down--;
            for (int i = down; i >= top; i--) {
                rst[i][left] = ++index;
            }
            left++;
        }
        return rst;
    }

}

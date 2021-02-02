package com.dove.study.likou;

/**
 * @Description: 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。
 * <p>
 * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 * <p>
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balls-in-a-box
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/2/1 下午2:22
 */
public class Solution7 {

    public static void main(String[] args) {
        int lowLimit = 1, highLimit = 100000;
        int i = countBalls(lowLimit, highLimit);
        System.out.println(i);

    }

    public static int countBalls(int lowLimit, int highLimit) {

        int[] arr = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            String s = String.valueOf(i);
            String[] split = s.split("");
            int sum = 0;
            for (int i1 = 0; i1 < split.length; i1++) {
                sum += Integer.parseInt(split[i1]);
            }
            arr[sum]++;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}

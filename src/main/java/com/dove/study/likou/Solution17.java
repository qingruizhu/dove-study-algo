package com.dove.study.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @Auther: qingruizhu
 * @Date: 2021/7/23 21:01
 */
public class Solution17 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length == 0) return new int[0][2];
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0], right = intervals[i][1];
            //
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}

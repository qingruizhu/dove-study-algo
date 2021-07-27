package com.dove.study.likou;

import java.util.HashMap;

/**
 * @Description: 560. 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * @Auther: qingruizhu
 * @Date: 2021/7/26 下午1:36
 */
public class Solution14 {


    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int presum = 0, count = 0;
        // pre - (pre-k) = k;
        for (Integer num : nums) {
            presum += num;
            if (preSumFreq.containsKey(presum - k)) {
                count += preSumFreq.get(presum - k);
            }
            preSumFreq.put(presum, preSumFreq.getOrDefault(presum, 0) + 1);
        }
        return count;

    }


}

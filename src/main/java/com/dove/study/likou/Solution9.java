package com.dove.study.likou;

/**
 * @Description: 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/2/2 上午9:31
 */
public class Solution9 {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int len = characterReplacement(s, k);
        System.out.println(len);
    }


    public static int characterReplacement(String s, int k) {
        // az 存储当前窗口内出现的字母的次数
        int[] az = new int[26];
        //当前窗口相同字母次数
        int maxCount = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int indexRight = chars[i] - 'A';
            //字母出现次数+1
            az[indexRight]++;
            //判断最大次数+1
            maxCount = Math.max(maxCount, az[indexRight]);
            // 判断是否缩小窗口
            if (i - left + 1 > maxCount + k) {
                int indexLeft = chars[left] - 'A';
                az[indexLeft]--;
                left++;
            }
        }
        // 返回窗口大小
        return chars.length - left;
    }


}

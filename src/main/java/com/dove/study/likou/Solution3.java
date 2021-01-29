package com.dove.study.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:字母异位词分组 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/1/28 下午6:11
 */
public class Solution3 {


    public static void main(String[] args) {
        String[] test = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        String[] test2 = {"", ""};
        List<List<String>> lists = groupAnagrams(test);
        System.out.println(lists.size());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());
    }

}

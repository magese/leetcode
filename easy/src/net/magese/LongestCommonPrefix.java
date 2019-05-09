package net.magese;

import java.util.HashSet;
import java.util.Set;

/**
 * 14. 最长公共前缀
 *
 * <a>https://leetcode-cn.com/problems/longest-common-prefix/description/</a>
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int i = 0;
        outer:
        while (true) {
            for (String str : strs) {
                if (str.length() > i)
                    set.add(str.charAt(i));
                else break outer;
            }
            if (set.size() == 1) {
                res.append(set.toArray()[0]);
                set.clear();
                i++;
            } else {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}

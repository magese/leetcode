package com.magese;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * <p/>
 * <a href="https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/">仅执行一次字符串交换能否使两个字符串相等</a>
 * <p/>
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p/>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p/>
 * <p/>
 * 示例 1：
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * <p/>
 * 示例 2：
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * <p/>
 * 示例 3：
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * <p/>
 * 示例 4：
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p/>
 * 提示：
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 * <p/>
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        String s1 = "bankac";
        String s2 = "kanacb";
        System.out.println(areAlmostEqual(s1, s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int diff = 0;
        char diff1 = '0';
        char diff2 = '0';
        boolean res = false;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                diff++;
                if (diff > 2) {
                    return false;
                } else if (diff == 2) {
                    res = diff1 == c2 && diff2 == c1;
                }

                diff1 = c1;
                diff2 = c2;
            }
        }

        return res;
    }
}

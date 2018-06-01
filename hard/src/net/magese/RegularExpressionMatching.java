package net.magese;

/**
 * <a>https://leetcode-cn.com/problems/regular-expression-matching/description/</a>
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching {
    private static boolean isMatch(String s, String p) {
        char[] s_char = s.toCharArray();
        char[] p_char = p.toCharArray();

        boolean[][] dp = new boolean[s_char.length + 1][p_char.length + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s_char.length; i++) {
            dp[i][0] = false;
        }

        for (int j = 2; j <= p_char.length; j++) {
            dp[0][j] = dp[0][j - 2] && p_char[j - 1] == '*';
        }

        for (int i = 1; i <= s_char.length; i++) {
            for (int j = 1; j <= p_char.length; j++) {
                if (p_char[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p_char[j - 2] == '.' || p_char[j - 2] == s_char[i - 1]));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s_char[i - 1] == p_char[j - 1] || p_char[j - 1] == '.');
                }
            }
        }

        return dp[s_char.length][p_char.length];
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(isMatch(s, p));
    }
}

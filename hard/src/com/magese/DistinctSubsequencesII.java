package com.magese;

/**
 * <p>940. 不同的子序列 II</p>
 * <p/>
 * <p><a href="https://leetcode.cn/problems/distinct-subsequences-ii/">不同的子序列</a></p>
 * <p/>
 * <p>给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。</p>
 * <p>字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。</p>
 * <p>例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。</p>
 * <p/>
 * <p>示例 1：</p>
 * <p>输入：s = "abc"</p>
 * <p>输出：7</p>
 * <p>解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。</p>
 * <p/>
 * <p>示例 2：</p>
 * <p>输入：s = "aba"</p>
 * <p>输出：6</p>
 * <p>解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。</p>
 * <p/>
 * <p>示例 3：</p>
 * <p>输入：s = "aaa"</p>
 * <p>输出：3</p>
 * <p>解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。</p>
 * <p/>
 * <p>提示：</p>
 * <p>1 <= s.length <= 2000</p>
 * <p>s 仅由小写英文字母组成</p>
 */
public class DistinctSubsequencesII {

    public static void main(String[] args) {
        String s = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(distinctSubseqII(s));
    }

    public static int distinctSubseqII(String s) {
        // 结果要对 (10^9 % 7) 取余
        int mod = (int)  Math.pow(10, 9) + 7;

        int[] preCount = new int[26];
        char a = 'a';
        char[] chars = s.toCharArray();
        int cur = 1;

        for (char c : chars) {
            // 每一次遍历，都等于上一次的结果加上当前的字符，假设上一次遍历结束有 4 个子串："", a, b, ab
            // 本次遍历字符 c，其新增的数量等于上一次的子串数量，添加后等于："", a, b, ab, ac, bc, abc, c ，共 8 个子串，以此类推
            int newCount = cur;
            // 总量 = 之前的量 + 新增的量 - 上一次该字符新增的量

            cur = (((cur + newCount) % mod) - (preCount[c - a] % mod) + mod) % mod;
            // 记录该字符上一次新增的数量
            preCount[c - a] = newCount;
        }

        return cur - 1;
    }
}

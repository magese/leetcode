package com.magese;

import java.util.Stack;

/**
 * 856. 括号的分数
 * <p/>
 * <a href="https://leetcode.cn/problems/score-of-parentheses">括号的分数</a>
 * <p/>
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p/>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p/>
 * 示例 1：
 * 输入： "()"
 * 输出： 1
 * <p/>
 * 示例 2：
 * 输入： "(())"
 * 输出： 2
 * <p/>
 * 示例 3：
 * 输入： "()()"
 * 输出： 2
 * <p/>
 * 示例 4：
 * 输入： "(()(()))"
 * 输出： 6
 * <p/>
 * 提示：
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 */
public class ScoreOfParentheses {


    public static void main(String[] args) {
        String s = "(()(()))";
        int resolve = resolve(s);
        System.out.println(resolve);
    }

    public static int resolve(String s) {

        Stack<Integer> stack = new Stack<>();
        boolean[] flags = new boolean[s.length()];

        int i = -1;
        while ((i = s.indexOf(")", i + 1)) >= 0) {

            if (s.lastIndexOf("(", i) == i - 1) {
                stack.push(1);
            } else {
                sum(s, i, stack, 0, 1, flags);
            }


        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    private static void sum(String s, int idx, Stack<Integer> stack, int sum, int c, boolean[] flags) {
        int begin = idx - 1;
        String at = s.substring(begin, idx);

        if (")".equals(at)) {
            c++;
            if (!flags[begin]) {
                flags[begin] = true;
                sum(s, begin, stack, sum + stack.pop(), c, flags);
            } else {
                sum(s, begin, stack, sum, c, flags);
            }
        } else {
            c--;
            if (c == 0) {
                stack.push(sum * 2);
            } else {
                sum(s, begin, stack, sum, c, flags);
            }
        }
    }

}

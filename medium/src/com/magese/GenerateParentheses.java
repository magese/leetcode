package com.magese;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaozhicheng
 * @since 2021/2/23 10:25
 *
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, n, n, "");
        return ans;
    }

    private static void dfs(List<String> res, int n1, int n2, String cur) {
        if (n1 == 0 && n2 == 0) {
            res.add(cur);
            return;
        }
        if (n1 > 0) {
            dfs(res, n1 - 1, n2, cur + "(");
        }
        if (n2 > n1) {
            dfs(res, n1, n2 - 1, cur + ")");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }
}

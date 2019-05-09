package net.magese;

import java.util.LinkedList;

/**
 * 20. 有效的括号
 *
 * <a>https://leetcode-cn.com/problems/valid-parentheses/description/</a>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    private static boolean isValid(String s) {
        boolean flag = true;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (list.size() == 0 || list.pop() != '(') {
                    flag = false;
                    break;
                }
            } else if (c == ']') {
                if (list.size() == 0 || list.pop() != '[') {
                    flag = false;
                    break;
                }
            } else if (c == '}') {
                if (list.size() == 0 || list.pop() != '{') {
                    flag = false;
                    break;
                }
            } else {
                list.push(c);
            }
        }
        if (list.size() != 0)
            flag = false;
        return flag;
    }

    public static void main(String[] args) {
        String s = "{";
        System.out.println(isValid(s));
    }
}

package net.magese;

import java.util.Scanner;

/**
 * 字符串转换整数 (atoi)
 *
 * <a>https://leetcode-cn.com/problems/string-to-integer-atoi/description/</a>
 * <p>
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * <p>
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * <p>
 * 若函数不能执行有效的转换，返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 */
public class ATOI {
    private static int myAtoi(String str) {
        // 将源字符串转换为目标数字字符串
        str = str.trim();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9')
                builder.append(c);
            else if ((c == '+' || c == '-') && i == 0)
                builder.append(c);
            else
                break;
        }

        if (builder.length() == 0)
            return 0;
        if (builder.charAt(0) == '+' || builder.charAt(0) == '-') {
            for (int i = 1; i < builder.length(); i++) {
                if (builder.charAt(i) == '0')
                    builder.deleteCharAt(i--);
                else break;
            }
            if (builder.length() == 1)
                return 0;
        } else {
            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) == '0')
                    builder.deleteCharAt(i--);
                else break;
            }
        }

        if (builder.length() > 0) {
            if (builder.length() <= 11) {
                long l = Long.parseLong(builder.toString());
                if (l > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if (l < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else
                    return (int) l;
            } else if (builder.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(myAtoi(sc.nextLine()));
        sc.close();
    }
}

package net.magese;

/**
 * <a>https://leetcode-cn.com/problems/zigzag-conversion/description/</a>
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * <p>
 * 实现一个将字符串进行指定行数变换的函数:
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Zconvert {
    private static String convert(String s, int numRows) {
        int x = numRows - 1;
        if (x < 1)
            return s;
        int y = s.length();
        int line = 0;
        // 计算数组长度
        while (y > 0) {
            if (line % x == 0)
                y -= numRows;
            else
                y -= 1;
            line++;
        }
        String[][] strArr = new String[numRows][line];

        int i = 0;
        while (s.length() > 0) {
            if (i % x == 0) {
                for (String[] strings : strArr) {
                    strings[i] = s.substring(0, 1);
                    s = s.substring(1);
                    if (s.length() == 0) break;
                }
            } else {
                int index = x - (i % x);
                String[] strings = strArr[index];
                strings[i] = s.substring(0, 1);
                s = s.substring(1);
            }
            i++;
        }

        StringBuilder builder = new StringBuilder();
        for (String[] strings : strArr) {
            for (String string : strings) {
                if (string != null)
                    builder.append(string);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}

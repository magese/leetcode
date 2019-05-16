package net.magese;


/**
 * 43. 字符串相乘
 *
 * <a>https://leetcode-cn.com/problems/multiply-strings/</a>
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class MultiplyStrings {
    private String multiply(String num1, String num2) {
        int carry = 0;
        int[] opt = new int[num1.length() + num2.length()];

        StringBuilder n1 = new StringBuilder(num1);
        n1.reverse();
        StringBuilder n2 = new StringBuilder(num2);
        n2.reverse();

        for (int i = 0; i < n1.length(); i++) {
            int x = n1.charAt(i) - 48;
            int unit = i;

            int j = 0;
            while (j < n2.length() || carry > 0) {
                int y = 0;
                if (j < n2.length())
                    y = n2.charAt(j) - 48;
                int product = x * y + carry + opt[unit];
                if (product > 9) {
                    opt[unit] = product % 10;
                    carry = product / 10;
                } else {
                    opt[unit] = product;
                    carry = 0;
                }
                j++;
                unit++;
            }

        }
        StringBuilder res = new StringBuilder();
        for (int i = opt.length - 1; i >= 0; i--) {
            if (opt[i] != 0 || res.length() > 0 || i == 0)
                res.append(opt[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num2 = "0";
        String num1 = "0";

        MultiplyStrings obj = new MultiplyStrings();
        System.out.println(obj.multiply(num1, num2));
    }
}

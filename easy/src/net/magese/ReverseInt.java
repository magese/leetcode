package net.magese;

/**
 * 7. 整数反转
 *
 * <a>https://leetcode-cn.com/problems/reverse-integer/description/</a>
 * <p>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInt {
    private static int reverse(int x) {
        String s = (x + "").replace("-", "");
        String num = new StringBuilder(s).reverse().toString();

        long l;
        if (x < 0)
            l = Long.parseLong("-" + num);
        else
            l = Long.parseLong(num);

        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) l;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}

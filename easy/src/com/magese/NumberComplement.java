package com.magese;

/**
 * 476. 数字的补数
 *
 * <a>https://leetcode-cn.com/problems/number-complement/</a>
 *
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 * 提示：
 *
 * 1 <= num < 23
 *
 * @author Magese
 * @since 2021/10/18 16:55
 */
public class NumberComplement {

    private static int findComplement(int num) {
        int sum = 0;
        int start = 1;

        while (num > 0) {
            int cur = num % 2;
            num /= 2;
            if (cur == 0){
                sum += start;
            }
            start *= 2;
        }
        return sum;
    }


    public static void main(String[] args) {
        int num = 1;
        System.out.println(findComplement(num));
    }

}

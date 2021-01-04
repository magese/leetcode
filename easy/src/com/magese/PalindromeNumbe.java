package com.magese;

/**
 * 9. 回文数
 *
 * <a>https://leetcode-cn.com/problems/palindrome-number/</a>
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumbe {
    private boolean isPalindrome(int x) {
        if (x < 0) return false;

        int i = 0;
        int residue = x;
        while (residue > 9) {
            residue /= 10;
            i++;
        }
        if (i == 0) return true;

        int j = 0;
        while (i >= j) {
            int divisor1 = (int) Math.pow(10, i);
            int divisor2 = (int) Math.pow(10, j);
            int high = x / divisor1 % 10;
            int low = x/ divisor2 % 10;
            if (high != low) return false;
            j++;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 10;

        PalindromeNumbe obj = new PalindromeNumbe();
        System.out.println(obj.isPalindrome(x));
    }
}

package net.magese;

import java.util.Scanner;

/**
 * 爬楼梯
 *
 * <a>https://leetcode-cn.com/problems/climbing-stairs/description/</a>
 *
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步
 */
public class ClimbStairs {
    private static int climbStairs(int n) {
        /*
        1 = 1
        2 = 2
        3 = 3
        4 = 5
        5 = 8
        斐波那契数列
         */
        int x = 1, y = 0;
        if (n == x || n == y)
            return 1;
        for (int i = 1; i <= n; i++) {
            int temp = x;
            x = x + y;
            y = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("共有" + climbStairs(sc.nextInt()) + "种方法可以爬到楼顶。");
        sc.close();
    }
}

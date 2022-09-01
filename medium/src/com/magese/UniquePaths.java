package com.magese;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 62. 不同路径
 * <p/>
 * <a href="https://leetcode.cn/problems/unique-paths/">不同路径</a>
 * <p/>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p/>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p/>
 * 问总共有多少条不同的路径？
 * <p/>
 * <p/>
 * <p/>
 * 示例 1：
 * <p/>
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png"/>
 * <p/>
 * 输入：m = 3, n = 7
 * 输出：28
 * <p/>
 * <p/>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * <p/>
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p/>
 * <p/>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p/>
 * <p/>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * <p/>
 * <p/>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 */
public class UniquePaths {

    private static int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            board[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            board[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] = board[i - 1][j] + board[i][j - 1];
            }
        }
        Arrays.stream(board).forEach(arr -> System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList())));
        return board[m -1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

}

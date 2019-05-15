package net.magese;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * <a>https://leetcode-cn.com/problems/combinations/</a>
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 输入: n = 4, k = 3
 * 输出:
 * [
 *   [1,2,3],
 *   [1,2,4],
 *   [1,3,4],
 *   [2,3,4],
 * ]
 */
public class Combinations {

    private List<List<Integer>> combine(int n, int k) {
        // 回溯算法，我不会，解不出来
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || n <= 0 || k <= 0) return res;


        int size = n * (n - 1) / k;

        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
            }

            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        Combinations obj = new Combinations();
        List<List<Integer>> combine = obj.combine(n, k);
        if (combine != null) {
            for (List<Integer> list : combine) {
                System.out.println(list);
            }
        }
    }
}

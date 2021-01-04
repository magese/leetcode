package com.magese;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * <a>https://leetcode-cn.com/problems/permutations/description/</a>
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        back(nums, integers, result);
        return result;
    }

    private static void back(int[] nums, List<Integer> integers, List<List<Integer>> result) {
        if (integers.size() == nums.length) {
            result.add(new ArrayList<>(integers));
        } else {
            for (int num : nums) {
                if (integers.contains(num)) continue;
                integers.add(num);
                back(nums, integers, result);
                integers.remove(integers.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }
}

package net.magese;

import java.util.Arrays;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * <a>https://leetcode-cn.com/problems/range-sum-query-immutable/</a>
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class RangeSumQueryImmutable {
    // 解法1：根据给出的范围索引对范围内的值进行累加
    /*private int[] nums;

    private RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }

    private int sumRange(int i, int j) {
        int sum = 0;
        int index = i;
        while (index <= j) {
            sum += nums[index];
            index++;
        }
        return sum;
    }*/

    // 解法2：给定数组时计算出每一种情况累加的值保存在二维数组中 (内存超了我艹)
    /*private int[][] res;

    private RangeSumQueryImmutable(int[] nums) {
        res = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                res[i][j] = res[i][j - 1] + nums[j];
            }
        }

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private int sumRange(int i, int j) {
        return res[i][j];
    }*/

    // 解法3：用一个一维数组保存前n项的和
    private int[] res;

    private RangeSumQueryImmutable(int[] nums) {
        if (nums.length < 1) {
            res = new int[]{0};
            return;
        }
        res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(res));
    }

    private int sumRange(int i, int j) {
        return i > 0 ? res[j] - res[i - 1] : res[j];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable sumQuery = new RangeSumQueryImmutable(nums);
        System.out.println(sumQuery.sumRange(0, 2));
        System.out.println(sumQuery.sumRange(2, 5));
        System.out.println(sumQuery.sumRange(0, 5));
    }
}

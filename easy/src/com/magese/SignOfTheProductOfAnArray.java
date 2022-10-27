package com.magese;

/**
 * <p>1822. 数组元素积的符号</p>
 * <p><a href="https://leetcode.cn/problems/sign-of-the-product-of-an-array/">数组元素积的符号</a></p>
 * <p>已知函数 signFunc(x) 将会根据 x 的正负返回特定值：</p>
 * <p>如果 x 是正数，返回 1 。</p>
 * <p>如果 x 是负数，返回 -1 。</p>
 * <p>如果 x 是等于 0 ，返回 0 。</p>
 * <p>给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。</p>
 * <p>返回 signFunc(product) 。</p>
 * <p/>
 * <p>示例 1：</p>
 * <p>输入：nums = [-1,-2,-3,-4,3,2,1]</p>
 * <p>输出：1</p>
 * <p>解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1</p>
 * <p/>
 * <p>示例 2：</p>
 * <p>输入：nums = [1,5,0,2,-3]</p>
 * <p>输出：0</p>
 * <p>解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0</p>
 * <p/>
 * <p>示例 3：</p>
 * <p>输入：nums = [-1,1,-1,1,-1]</p>
 * <p>输出：-1</p>
 * <p>解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1</p>
 * <p/>
 * <p>提示：</p>
 * <p>1 <= nums.length <= 1000</p>
 * <p>-100 <= nums[i] <= 100</p>
 */
public class SignOfTheProductOfAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,-1,1,-1};
        System.out.println(arraySign(nums));
    }


    public static int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) {
                negativeCount++;
            }
        }
        return negativeCount % 2 == 0 ? 1 : -1;
    }

}

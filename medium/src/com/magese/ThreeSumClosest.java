package com.magese;

import java.util.Arrays;

/**
 * @author gaozhicheng
 * @since 2021/2/1 14:21
 *
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < nums.length) {
                int sum = nums[l] + nums[i] + nums[r];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < min) {
                    ans = sum;
                    min = Math.abs(sum - target);
                }
                if (sum > target) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}

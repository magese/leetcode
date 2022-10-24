package com.magese;

/**
 * <p>915. 分割数组</p>
 * <p><a href="https://leetcode.cn/problems/partition-array-into-disjoint-intervals/comments/">分割数组</a></p>
 * <p>给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：</p>
 * <p>left 中的每个元素都小于或等于 right 中的每个元素。</p>
 * <p>left 和 right 都是非空的。</p>
 * <p>left 的长度要尽可能小。</p>
 * <p>在完成这样的分组后返回 left 的 长度 。</p>
 * <p>用例可以保证存在这样的划分方法。</p>
 * <p/>
 * <p>示例 1：</p>
 * <p>输入：nums = [5,0,3,8,6]</p>
 * <p>输出：3</p>
 * <p>解释：left = [5,0,3]，right = [8,6]</p>
 * <p/>
 * <p>示例 2：</p>
 * <p>输入：nums = [1,1,1,0,6,12]</p>
 * <p>输出：4</p>
 * <p>解释：left = [1,1,1,0]，right = [6,12]</p>
 * <p/>
 * <p>提示：</p>
 * <p>2 <= nums.length <= 105</p>
 * <p>0 <= nums[i] <= 106</p>
 * <p>可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。</p>
 */
public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.println(partitionDisjoint(nums));
    }

    public static int partitionDisjoint(int[] nums) {
        int max = 0;
        int leftMax = 0;
        int min = nums[0];
        int minIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (i <= minIdx && nums[i] >= leftMax) {
                leftMax = nums[i];
            }

            if (i > minIdx && nums[i] < leftMax) {
                leftMax = max;
                minIdx = i;
            }
        }

        return minIdx + 1;
    }

}

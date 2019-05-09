package net.magese;

/**
 * 35. 搜索插入位置
 *
 * <a>https://leetcode-cn.com/problems/search-insert-position/description/</a>
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {
    private static int searchInsert(int[] nums, int target) {
        int index = 0;
        if (nums.length < 1 || target < nums[0])
            return 0;
        else if (target > nums[nums.length - 1])
            return nums.length;

        if (target > nums[nums.length / 2]) {
            for (int i = nums.length / 2; i < nums.length; i++) {
                if (target <= nums[i]) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = nums.length / 2; i >= 0; i--) {
                if (target == nums[i]) {
                    index = i;
                    break;
                } else if (target > nums[i]) {
                    index = i + 1;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}

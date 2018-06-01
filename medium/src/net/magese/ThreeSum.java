package net.magese;

import java.util.*;

/**
 * <a>https://leetcode-cn.com/problems/3sum/description/</a>
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        // 对数组排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果元素重复则跳过当次
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                // 如果元素重复则跳过当次
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    j++;
                    continue;
                }
                // 如果元素重复则跳过当次
                if (k < nums.length - 2 && nums[k + 1] == nums[k]) {
                    k--;
                    continue;
                }
                // 求和
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) { // 如果结果大于零则将被加数变小
                    k--;
                } else if (sum < 0) { // 如果结果小于零则将被加数变大
                    j++;
                } else { // 如果结果等于0则表示符合题目条件 添加到集合中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}

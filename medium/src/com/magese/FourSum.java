package com.magese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaozhicheng
 * @since 2021/2/22 10:10
 *
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        // 初始化索引数组
        int[] index = {0, 1, 2, 3};
        // 先排序
        Arrays.sort(nums);
        while (index[3] != 0) {
            if ((nums[index[0]] + nums[index[1]] + nums[index[2]] + nums[index[3]]) == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[index[0]]);
                list.add(nums[index[1]]);
                list.add(nums[index[2]]);
                list.add(nums[index[3]]);
                if (!ans.contains(list)) ans.add(list);
            }
            next(index, 3, nums.length);
        }
        return ans;
    }

    /**
     * 递归寻找下一个数
     */
    private static void next(int[] index, int next, int len) {
        // 如果下一个索引小于0表示遍历完了
        if (next < 0) {
            index[3] = 0;
            return;
        }
        // 判断当前索引的值是否超过了它的最大值，没有则+1，有则向上一位+1
        if (index[next] < len - (index.length - next)) {
            index[next] += 1;
            // 判断当前索引是否是最后一位，如果不是，则将它后面的数值重置
            if (next < index.length - 1) {
                int add = 1;
                for (int i = next + 1; i < index.length; i++) {
                    index[i] = index[next] + add++;
                }
            }
        } else {
            next(index, next - 1, len);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        int target = 0;
        fourSum(nums, target).forEach(System.out::println);
    }

}

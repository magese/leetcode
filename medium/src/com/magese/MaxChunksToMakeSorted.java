package com.magese;

/**
 * <p>769. 最多能完成排序的块
 * <p/>
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted/">最多能完成排序的块</a>
 * <p>给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。</p>
 * <p>我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。</p>
 * <p>返回数组能分成的最多块数量。</p>
 * <p/>
 * <p>示例 1:</p>
 * <p>输入: arr = [4,3,2,1,0]</p>
 * <p>输出: 1</p>
 * <p>解释:</p>
 * <p>将数组分成2块或者更多块，都无法得到所需的结果。</p>
 * <p>例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。</p>
 * <p/>
 * <p>示例 2:</p>
 * <p>输入: arr = [1,0,2,3,4]</p>
 * <p>输出: 4</p>
 * <p>解释:</p>
 * <p>我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。</p>
 * <p>然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。</p>
 * <p/>
 * <p>提示:</p>
 * <p>n == arr.length</p>
 * <p>1 <= n <= 10</p>
 * <p>0 <= arr[i] < n</p>
 * <p>arr 中每个元素都 不同</p>
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int count = 0;
        int target = 0;
        boolean flag = false;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int at = arr[i];
            if (at == target) {
                flag = true;
            }
            max = Math.max(at, max);

            if (i == max && flag) {
                count++;
                target = max + 1;
                flag = false;
            }
        }

        return count;
    }

}

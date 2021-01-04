package com.magese;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * <a>https://leetcode-cn.com/problems/merge-sorted-array/description/</a>
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while (j < n && i < nums1.length) {
            if (i >= m) {
                nums1[i] = nums2[j];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                System.arraycopy(nums1, i, nums1, i + 1, nums1.length - 1 - i);
                nums1[i] = nums2[j];
                j++;
                m++;
            }
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

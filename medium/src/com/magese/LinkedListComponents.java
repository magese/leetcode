package com.magese;

import com.magese.common.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * 817. 链表组件
 * <p/>
 * <a href="https://leetcode.cn/problems/linked-list-components/">链表组件</a>
 * <p/>
 * <p>给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。</p>
 * <p>返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。</p>
 * <p/>
 * 示例 1：
 * <p/>
 * <img src="https://assets.leetcode.com/uploads/2021/07/22/lc-linkedlistcom1.jpg"/>
 * <p/>
 * <p>输入: head = [0,1,2,3], nums = [0,1,3]</p>
 * <p>输出: 2</p>
 * <p>解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。</p>
 * <p/>
 * 示例 2：
 * <p/>
 * <img src="https://assets.leetcode.com/uploads/2021/07/22/lc-linkedlistcom2.jpg"/>
 * <p>输入: head = [0,1,2,3,4], nums = [0,3,1,4]</p>
 * <p>输出: 2</p>
 * <p>解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。</p>
 * <p/>
 * <p>提示：</p>
 * <p>链表中节点数为n</p>
 * <p>1 <= n <= 104</p>
 * <p>0 <= Node.val < n</p>
 * <p>Node.val 中所有值 不同</p>
 * <p>1 <= nums.length <= n</p>
 * <p>0 <= nums[i] < n</p>
 * <p>nums 中所有值 不同</p>
 */
public class LinkedListComponents {

    public static void main(String[] args) {
        ListNode head = ListNode.create(0);
        head.createNext(1)
                .createNext(2)
                .createNext(3)
                .createNext(4);
        int[] nums = new int[]{0, 3, 1, 4};
        System.out.println(numComponents(head, nums));
    }


    public static int numComponents(ListNode head, int[] nums) {
        List<Integer> list = new java.util.ArrayList<>(Arrays.stream(nums).boxed().toList());
        boolean flag = false;
        int count = 0;

        ListNode current = head;
        while (current != null) {
            int val = current.val;

            if (list.removeIf(i -> i == val)) {
                flag = true;
            } else if (flag) {
                count++;
                flag = false;
            }

            current = current.next;
        }

        if (flag) {
            count++;
        }

        return count;
    }
}

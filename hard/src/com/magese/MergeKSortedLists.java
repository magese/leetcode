package com.magese;

import com.magese.common.ListNode;

/**
 * @author gaozhicheng
 * @since 2021/2/23 14:10
 *
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKSortedLists {

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int index = findMinIndex(lists);
        if (index < 0) return null;
        ListNode head = new ListNode(lists[index].val);
        lists[index] = lists[index].next;
        ListNode cur = head;

        while (true) {
            index = findMinIndex(lists);
            if (index < 0) break;
            cur.next = new ListNode(lists[index].val);
            cur = cur.next;
            lists[index] = lists[index].next;
        }
        return head;
    }

    private static int findMinIndex(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.setNext(4).setNext(5);
        ListNode l2 = new ListNode(1);
        l2.setNext(3).setNext(4);
        ListNode l3 = new ListNode(2);
        l3.setNext(6);
        ListNode[] listNodes = {null};
        System.out.println(mergeKLists(listNodes));
    }
}

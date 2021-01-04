package com.magese;

/**
 * 83. 删除排序链表中的重复元素
 *
 * <a>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/</a>
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(head.val);
        ListNode next = res;
        ListNode current = head;
        while (current.next != null) {
            if (current.val != current.next.val) {
                next.next = new ListNode(current.next.val);
                next = next.next;
            }
            current = current.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode res = obj.deleteDuplicates(head);
        System.out.println(res);
    }
}

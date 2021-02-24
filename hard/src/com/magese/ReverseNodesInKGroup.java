package com.magese;

import com.magese.common.ListNode;

/**
 * @author gaozhicheng
 * @since 2021/2/24 10:27
 *
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodesInKGroup {

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        return reverse(head, k, k);
    }

    private static ListNode reverse(ListNode head, int k, int c) {
        if (head == null || head.next == null)
            return head;
        if (c == 1) {
            head.next = reverse(head.next, k, k);
            return head;
        }
        ListNode node = reverse(head.next, k, c - 1);
        ListNode next = node;
        int i = c;
        while (--i > 0) {
            if (next == null) return head;
            next = next.next;
        }
        head.next = next;
        next = node;
        i = c;
        while (--i > 1) {
            if (next == null) return head;
            next = next.next;
        }
        next.next = head;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3).setNext(4).setNext(5).setNext(6).setNext(7);
        int k = 4;
        System.out.println(reverseKGroup(head, k));
    }
}

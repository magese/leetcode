package com.magese;

import com.magese.common.ListNode;

/**
 * @author gaozhicheng
 * @since 2021/2/22 16:06
 *
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {

    private static int cur = 0;

    /**
     * 双指针解法
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 递归解法
     */
    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd2(head.next, n);
        cur++;
        if (cur == n) return head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.setNext(n1).setNext(n2).setNext(n3).setNext(n4);
        int n = 2;
        System.out.println(head);
        System.out.println(removeNthFromEnd2(head, n));
    }
}

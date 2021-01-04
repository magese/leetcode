package com.magese;

/**
 * 2. 两数相加
 *
 * <a>https://leetcode-cn.com/problems/add-two-numbers/</a>
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode next = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int x = 0, y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int sum = x + y + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            if (res == null) {
                res = new ListNode(sum);
                next = res;
            } else {
                next.next = new ListNode(sum);
                next = next.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(5);
        l1.next = m1;
        m1.next = m2;

        ListNode l2 = new ListNode(5);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        l2.next = n1;
        n1.next = n2;

        System.out.println("l1:" + l1);
        System.out.println("l2:" + l2);
        AddTwoNumbers obj = new AddTwoNumbers();
        System.out.println("res:" + obj.addTwoNumbers(l1, l2));
    }
}

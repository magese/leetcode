package com.magese;

import com.magese.common.ListNode;

/**
 * 86. 分隔链表
 *
 * <a>https://leetcode-cn.com/problems/partition-list/</a>
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class PartitionList {

    private ListNode partition(ListNode head, int x) {
        ListNode pre = null;
        ListNode preHead = null;
        ListNode aft = null;
        ListNode aftHead = null;

        ListNode loop = head;
        while (loop != null) {
            int val = loop.val;
            if (val < x) {
                if (preHead == null) {
                    preHead = loop;
                } else {
                    pre.next = loop;
                }
                pre = loop;
            } else {
                if (aftHead == null) {
                    aftHead = loop;
                } else {
                    aft.next = loop;
                }
                aft = loop;
            }
            loop = loop.next;
        }
        if (aft != null && aft.next != null)
            aft.next = null;
        ListNode res = null;
        if (preHead != null && aftHead != null) {
            pre.next = aftHead;
            res = preHead;
        } else if (preHead != null) {
            res = preHead;
        } else if (aftHead != null) {
            res = aftHead;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(4);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(2);
        ListNode next4 = new ListNode(5);
        ListNode next5 = new ListNode(2);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        int x = 3;
        System.out.println(head);
        PartitionList partitionList = new PartitionList();
        System.out.println(partitionList.partition(head, x));
    }
}

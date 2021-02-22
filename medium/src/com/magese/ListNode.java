package com.magese;

/**
 * 链表实体
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this.next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode loop = this;
        while (loop != null) {
            builder.append("[").append(loop.val).append("]");
            loop = loop.next;
            if (loop != null) builder.append("->");
        }
        return builder.toString();
    }
}

package com.magese.common;

/**
 * 链表实体
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this.next;
    }

    public ListNode setNext(int nextVal) {
        return setNext(new ListNode(nextVal));
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

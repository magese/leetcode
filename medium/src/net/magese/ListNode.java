package net.magese;

/**
 * 链表实体
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode loop = this;
        while (loop != null) {
            builder.append(loop.val);
            loop = loop.next;
            if (loop != null) builder.append("->");
        }
        return builder.toString();
    }
}

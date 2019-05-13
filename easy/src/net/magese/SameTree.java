package net.magese;

import java.util.*;

/**
 * 100. 相同的树
 *
 * <a>https://leetcode-cn.com/problems/same-tree/</a>
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class SameTree {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = true;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                res = false;
                break;
            }
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.left);
            queue2.offer(node2.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        p.left = n2;
        p.right = n3;

        q.left = n2;
        q.right = n3;
        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(p, q));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
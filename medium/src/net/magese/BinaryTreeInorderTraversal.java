package net.magese;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 *
 * <a>https://leetcode-cn.com/problems/binary-tree-inorder-traversal/</a>
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreeInorderTraversal {
    // 递归实现
    /*private List<Integer> res = new ArrayList<>();
    private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;

        if (root.left != null)
            inorderTraversal(root.left);

        res.add(root.val);

        if (root.right != null)
            inorderTraversal(root.right);

        return res;
    }*/

    // 迭代实现
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();
        System.out.println(obj.inorderTraversal(root));
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


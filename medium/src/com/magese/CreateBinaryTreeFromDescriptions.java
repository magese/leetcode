package com.magese;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>2196. 根据描述创建二叉树</p>
 * <p><a href="https://leetcode.cn/problems/create-binary-tree-from-descriptions/">根据描述创建二叉树</a></p>
 * <p/>
 * <p>给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：</p>
 * <p>如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。</p>
 * <p>如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。</p>
 * <p>请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。</p>
 * <p>测试用例会保证可以构造出 有效 的二叉树。</p>
 * <p/>
 * <p/>
 * <p>示例 1：</p>
 * <p><img src="https://assets.leetcode.com/uploads/2022/02/09/example1drawio.png" /></p>
 * <p>输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]</p>
 * <p>输出：[50,20,80,15,17,19]</p>
 * <p>解释：根节点是值为 50 的节点，因为它没有父节点。</p>
 * <p>结果二叉树如上图所示。</p>
 * <p/>
 * <p>示例 2：</p>
 * <p><img src="https://assets.leetcode.com/uploads/2022/02/09/example2drawio.png" /></p>
 * <p>输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]</p>
 * <p>输出：[1,2,null,null,3,4]</p>
 * <p>解释：根节点是值为 1 的节点，因为它没有父节点。 </p>
 * <p>结果二叉树如上图所示。 </p>
 * <p/>
 * <p>提示：</p>
 * <p>1 <= descriptions.length <= 104</p>
 * <p>descriptions[i].length == 3</p>
 * <p>1 <= parenti, childi <= 105</p>
 * <p>0 <= isLefti <= 1</p>
 * <p>descriptions 所描述的二叉树是一棵有效二叉树</p>
 */
public class CreateBinaryTreeFromDescriptions {

    public static void main(String[] args) {
        // [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
        int[] inner1 = new int[]{20, 15, 1};
        int[] inner2 = new int[]{20, 17, 0};
        int[] inner3 = new int[]{50, 20, 1};
        int[] inner4 = new int[]{50, 80, 0};
        int[] inner5 = new int[]{80, 19, 1};
        int[][] descriptions = new int[][]{inner1, inner2, inner3, inner4, inner5};
        System.out.println(createBinaryTree(descriptions));
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean left = desc[2] == 1;

            TreeNode pNode = nodeMap.getOrDefault(parent, new TreeNode(parent));
            TreeNode cNode = nodeMap.getOrDefault(child, new TreeNode(child));

            if (left) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }

            nodeMap.putIfAbsent(parent, pNode);
            nodeMap.putIfAbsent(child, cNode);
            set.add(child);
        }

        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            if (!set.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            // 得到树的深度
            int treeDepth = getTreeDepth(this);

            // 最后一行的宽度为2的（n - 1）次方乘3，再加1
            // 作为整个二维数组的宽度
            int arrayHeight = treeDepth * 2 - 1;
            int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
            // 用一个字符串数组来存储每个位置应显示的元素
            String[][] res = new String[arrayHeight][arrayWidth];
            // 对数组进行初始化，默认为一个空格
            for (int i = 0; i < arrayHeight; i++) {
                for (int j = 0; j < arrayWidth; j++) {
                    res[i][j] = " ";
                }
            }

            // 从根节点开始，递归处理整个树
            writeArray(this, 0, arrayWidth / 2, res, treeDepth);

            // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
            StringBuilder sb = new StringBuilder();
            for (String[] line : res) {
                for (int i = 0; i < line.length; i++) {
                    sb.append(line[i]);
                    if (line[i].length() > 1 && i <= line.length - 1) {
                        i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                    }
                }
                sb.append("\r\n");
            }
            return sb.toString();
        }

        public int getTreeDepth(TreeNode root) {
            return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
        }


        private void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
            // 保证输入的树不为空
            if (currNode == null) return;
            // 先将当前节点保存到二维数组中
            res[rowIndex][columnIndex] = String.valueOf(currNode.val);

            // 计算当前位于树的第几层
            int currLevel = ((rowIndex + 1) / 2);
            // 若到了最后一层，则返回
            if (currLevel == treeDepth) return;
            // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
            int gap = treeDepth - currLevel - 1;

            // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
            if (currNode.left != null) {
                res[rowIndex + 1][columnIndex - gap] = "/";
                writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
            }

            // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
            if (currNode.right != null) {
                res[rowIndex + 1][columnIndex + gap] = "\\";
                writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
            }
        }
    }
}

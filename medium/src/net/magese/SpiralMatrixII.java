package net.magese;

/**
 * 59. 螺旋矩阵 II
 *
 * <a>https://leetcode-cn.com/problems/spiral-matrix-ii/</a>
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {

    private int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 当前数值
        int ele = 1;
        // 下标位置
        int i = 0;
        int j = 0;
        // 边界值
        int min = 0;
        int max = n - 1;
        // true时增 false时减
        boolean flag = true;

        for (int times = 0; times < n * n; times++) {
            res[i][j] = ele++;

            if (flag) {
                if (j < max) {
                    j++;
                } else if (i < max) {
                    i++;
                } else {
                    j--;
                    flag = false;
                }
            } else {
                if (j > min) {
                    j--;
                } else if (i > min + 1) {
                    i--;
                } else {
                    flag = true;
                    min++;
                    max--;
                    i = min;
                    j = min;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int n = 5;
        int[][] matrix = spiralMatrixII.generateMatrix(n);

        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("[ ");
                for (int j = 0; j < matrix[i].length; j++) {
                    int column = matrix[i][j];
                    String s = "";
                    if (column < 10)
                        s = "0";
                    System.out.print(s + column);
                    if (j != matrix[i].length - 1)
                        System.out.print(", ");
                }
                System.out.print(" ]");
                if (i != matrix.length - 1)
                    System.out.println(",");
            }
            System.out.println();
        }
    }
}

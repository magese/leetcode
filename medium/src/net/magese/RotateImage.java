package net.magese;

/**
 * 48. 旋转图像
 *
 * <a>https://leetcode-cn.com/problems/rotate-image/</a>
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {

    private void rotate(int[][] matrix) {
        int maxHeight = matrix.length % 2 == 0 ? matrix.length / 2 : matrix.length / 2 + 1;
        for (int i = 0; i < maxHeight; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix[i].length - 1 - j];
                matrix[matrix.length - 1 - i][matrix[i].length - 1 - j] = matrix[j][matrix[i].length - 1 - i];
                matrix[j][matrix[i].length - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

        printArray(matrix);
        RotateImage obj = new RotateImage();
        obj.rotate(matrix);
        printArray(matrix);

    }

    private static void printArray(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < arr[i].length; j++) {
                String zero = arr[i][j] > 9 ? "" : "0";
                System.out.print(zero + arr[i][j]);
                if (j != arr[i].length - 1)
                    System.out.print(",");
            }
            System.out.print("]");
            if (i != arr.length - 1)
                System.out.print(",");
            System.out.println();
        }
        System.out.println("]");
    }
}

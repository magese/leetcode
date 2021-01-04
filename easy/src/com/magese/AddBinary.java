package com.magese;

/**
 * 67. 二进制求和
 *
 * <a>https://leetcode-cn.com/problems/add-binary/</a>
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    private static String addBinary(String a, String b) {

        StringBuilder builder = new StringBuilder();
        int carryBit = 0;

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        while (aIndex >= 0 || bIndex >= 0) {
            int aInt = 0;
            if (aIndex >= 0)
                aInt = Integer.parseInt(String.valueOf(a.charAt(aIndex)));
            int bInt = 0;
            if (bIndex >= 0)
                bInt = Integer.parseInt(String.valueOf(b.charAt(bIndex)));
            int sum = aInt + bInt + carryBit;

            switch (sum) {
                case 0:
                    carryBit = 0;
                    builder.insert(0, 0);
                    break;
                case 1:
                    carryBit = 0;
                    builder.insert(0, 1);
                    break;
                case 2:
                    carryBit = 1;
                    builder.insert(0, 0);
                    break;
                default:
                    carryBit = 1;
                    builder.insert(0, 1);
                    break;
            }

            aIndex--;
            bIndex--;
        }

        if (carryBit > 0) builder.insert(0, carryBit);
        return builder.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}

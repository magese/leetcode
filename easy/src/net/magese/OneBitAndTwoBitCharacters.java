package net.magese;

/**
 * 717. 1比特与2比特字符
 *
 * <a>https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/</a>
 * <p>
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 * <p>
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * <p>
 * 注意:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class OneBitAndTwoBitCharacters {
    // 一个比特设为true，两个比特设为false
    private static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) return true;
        boolean[] dp = new boolean[bits.length];
        dp[0] = bits[0] == 0;
        for (int i = dp[0] ? 1 : 2; i < bits.length; i++) {
            if (bits[i] == 1) {
                dp[i] = false;
                dp[i + 1] = false;
                i++;
            } else {
                dp[i] = true;
            }
        }
        return dp[bits.length - 1];
    }

    // 最后一个字符的比特只与最后一个0之前有多少个连续的1有关
    private static boolean isOneBitCharacter2(int[] bits) {
        int count = 0;
        int index = bits.length - 2;
        while (index >= 0 && bits[index] == 1) {
            count++;
            index--;
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
        System.out.println(isOneBitCharacter2(bits));
    }
}

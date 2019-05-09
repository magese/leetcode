package net.magese;

/**
 * 38. 报数
 *
 * <a>https://leetcode-cn.com/problems/count-and-say/description/</a>
 * <p>
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class CounAndSay {
    private static String countAndSay(int n) {
        String begin = "1";                                                 // 设置起始数
        for (int i = 1; i < n; i++) {                                       // 需要n-1次循环
            StringBuilder res = new StringBuilder();                        // 每次循环结果
            int count = 0;                                                  // 计数变量
            char mark = begin.charAt(0);                                    // 记录当前计数变量的字符 默认为起始数0索引上的数字
            for (int j = 0; j < begin.length(); j++) {                      // 对当前起始数进行遍历
                char c = begin.charAt(j);                                   // 当前循环到的字符
                if (c == mark) {                                            // 如果当前循环的字符与计数的字符一致
                    count++;                                                // 计数器自增1
                } else {                                                    // 如果当前循环字符与计数字的字符不同
                    res.append(count).append(mark);                         // 记录下该字符出现的次数
                    mark = c;                                               // 计数的字符更换为当前循环的字符
                    count = 1;                                              // 计数器重置为1
                }
            }
            res.append(count).append(mark);                                 // 当一轮循环结束，将最后的计数字符与数量也添加到结果中
            begin = res.toString();                                         // 设置起始数为本次循环结果
        }
        return begin;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countAndSay(n));
    }
}

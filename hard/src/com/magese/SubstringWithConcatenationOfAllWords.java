package com.magese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaozhicheng
 * @since 2021/2/25 16:37
 *
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubstringWithConcatenationOfAllWords {

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length <= 0 || words[0].length() <= 0) return ans;
        int len = words[0].length();
        boolean[] flags = new boolean[words.length];
        int i = 0;
        while (i < s.length() - len + 1) {
            String sub = s.substring(i, i + len);
            boolean b = false;
            for (int j = 0; j < words.length; j++) {
                if (flags[j]) continue;
                if (sub.equals(words[j])) {
                    flags[j] = true;
                    b = true;
                    i += len;
                    break;
                }
            }
            if (b) {
                for (boolean flag : flags) {
                    if (!flag) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    i -= len * flags.length;
                    ans.add(i);
                    i++;
                    Arrays.fill(flags, false);
                }
            } else {
                int c = 0;
                for (boolean flag : flags) {
                    if (flag) c++;
                }
                i -= c * len;
                i++;
                Arrays.fill(flags, false);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        System.out.println(findSubstring(s, words));
    }
}

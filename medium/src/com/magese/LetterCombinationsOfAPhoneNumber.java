package com.magese;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaozhicheng
 * @since 2021/2/19 10:18
 *
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {

    private static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        final Map<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

        List<String[]> letters = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            letters.add(map.get(String.valueOf(digits.charAt(i))));
        }


        int[] counts = new int[letters.size()];
        StringBuilder letter = new StringBuilder();

        int i = 0;
        int j = counts.length - 1;
        while (counts[0] != -1) {
            String[] letterArr = letters.get(i);
            letter.append(letterArr[counts[i]]);
            i++;
            if (i == letters.size()) {
                i = 0;
                ans.add(letter.toString());
                letter.setLength(0);
                cursor(counts, letters, j);
            }
        }
        return ans;
    }

    private static void cursor(int[] counts, List<String[]> letters, int i) {
        if (i < 0) {
            counts[0] = -1;
            return;
        }
        counts[i] += 1;
        if (counts[i] >= letters.get(i).length) {
            counts[i] = 0;
            cursor(counts, letters, i - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

}

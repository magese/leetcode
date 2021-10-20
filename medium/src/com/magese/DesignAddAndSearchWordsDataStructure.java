package com.magese;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * <a>https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/</a>
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * @author Magese
 * @since 2021/10/19 9:19
 */
public class DesignAddAndSearchWordsDataStructure {

    private static class WordDictionary {

        private final TreeDict dict;

        public WordDictionary() {
            dict = new TreeDict();
        }

        public void addWord(String word) {
            dict.insert(word);
        }

        public boolean search(String word) {
            return search(word, 0, word.length() - 1, dict.children);
        }

        private boolean search(String word, int index, int end, TreeDict[] nodes) {
            if (index > end) return false;
            char c = word.charAt(index);
            if (c != '.') {
                int at = c - 'a';
                if (nodes[at] == null) return false;
                else if (nodes[at] != null && nodes[at].isEnd && index == end) return true;
                return search(word, index + 1, end, nodes[at].children);
            } else {
                for (int i = 0; i < 26; i++) {
                    if (nodes[i] != null) {
                        if (index == end && nodes[i].isEnd) {
                            return true;
                        }
                        boolean b = search(word, index + 1, end, nodes[i].children);
                        if (b) return true;
                    }
                }
                return false;
            }
        }

        private static class TreeDict {

            private boolean isEnd;
            private final TreeDict[] children;

            public TreeDict() {
                this.isEnd = false;
                this.children = new TreeDict[26];
            }

            public void insert(String word) {
                TreeDict node = this;
                for (int i = 0; i < word.length(); i++) {
                    int charAt = word.charAt(i);
                    int index = charAt - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TreeDict();
                    }
                    node = node.children[index];
                }
                node.isEnd = true;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("ab");
        wd.addWord("a");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
    }
}

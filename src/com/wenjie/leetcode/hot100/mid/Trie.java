package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  208. 实现 Trie (前缀树)
 * Created on 2022/1/11 9:37
 * @author iswenjie.lu
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, true);
    }

    public boolean startsWith(String prefix) {
        return search(prefix, false);
    }

    public boolean search(String word, boolean isWord) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return !isWord || node.isEnd;
    }


}

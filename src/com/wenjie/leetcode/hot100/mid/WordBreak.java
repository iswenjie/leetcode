package com.wenjie.leetcode.hot100.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:  139. 单词拆分
 * Created on 2022/1/4 17:04
 * @author iswenjie.lu
 */
public class WordBreak {


    public static void main(String[] args) {
        String s = "cats";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        System.out.println(new WordBreak().wordBreakRec(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] & wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 递归解法，超时
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakRec(String s, List<String> wordDict) {
        boolean ans = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() != word.length()) {
                    ans = wordBreakRec(s.substring(word.length()), wordDict);
                } else {
                    ans = true;
                }
            }
            if (ans) {
                return true;
            }
        }
        return ans;
    }

}

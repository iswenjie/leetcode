package com.wenjie.leetcode.offer;

import java.util.Arrays;

/**
 * Description:  剑指 Offer 05. 替换空格
 * Created on 2022/1/5 10:45
 * @author iswenjie.lu
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        new ReplaceSpace().replaceSpace(" he llo wp ");
    }

    public String replaceSpace(String s) {
        int blankNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (32 == s.charAt(i)) {
                blankNum++;
            }
        }
        int newLen = s.length() + 2 * blankNum;
        char[] newStr = Arrays.copyOf(s.toCharArray(), newLen);
        int i = s.length() - 1, j = newLen - 1;
        while (i != j) {
            if (32 != s.charAt(i)) {
                newStr[j] = s.charAt(i);
                j--;
            } else {
                newStr[j - 2] = '%';
                newStr[j - 1] = '2';
                newStr[j] = '0';
                j -= 3;
            }
            i--;
        }
        return new String(newStr);
    }

}

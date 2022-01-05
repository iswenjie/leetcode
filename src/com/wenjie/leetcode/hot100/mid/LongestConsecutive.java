package com.wenjie.leetcode.hot100.mid;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:  128. 最长连续序列
 * Created on 2022/1/4 11:10
 * @author iswenjie.lu
 */
public class LongestConsecutive {


    public static void main(String[] args) {
        int[] arr = {-6, 8, -5, 7, -9, -1, -7, -6, -9, -7, 5, 7, -1, -8, -8, -2, 0};
        System.out.println(new LongestConsecutive().longestConsecutive(arr));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer i : set) {
            if (!set.contains(i + 1)) {
                int curr = 1;
                while (set.contains(--i)) {
                    curr++;
                }
                longest = Math.max(curr, longest);
            }
        }
        return longest;

    }

}

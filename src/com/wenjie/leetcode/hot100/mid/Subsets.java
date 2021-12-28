package com.wenjie.leetcode.hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  78. 子集
 * Tag: 动态规划
 * Created on 2021/12/27 16:58
 * @author iswenjie.lu
 */
public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3});
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> toBeAdd = new ArrayList<>();
            for (List<Integer> an : ans) {
                List<Integer> list = new ArrayList<>(an);
                list.add(num);
                toBeAdd.add(list);
            }
            ans.addAll(toBeAdd);
        }
        return ans;
    }

}

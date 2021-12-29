package com.wenjie.leetcode.hot100.mid;

/**
 * Description: 96. 不同的二叉搜索树
 * Tag: 动态规划、笛卡尔积
 * Created on 2021/12/29 10:41
 * @author iswenjie.lu
 */
public class DiffNumTrees {

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}

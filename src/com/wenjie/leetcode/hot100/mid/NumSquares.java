package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  279. 完全平方数
 * Created on 2022/1/24 10:18
 * @author iswenjie.lu
 */
public class NumSquares {


    public static void main(String[] args) {
        new NumSquares().numSquares(12);
    }

    public int numSquares(int n) {
        // 动态规划
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // 当前 i = j^2 + (i - j^2)
                // f(i - j^2) 的次数已经算过，j^2 就是增加一个次数
                // 最后取最小的 min
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

}
